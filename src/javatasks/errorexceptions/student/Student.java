package javatasks.errorexceptions.student;


import javatasks.errorexceptions.customsexception.MarkOutOfBoundsException;
import javatasks.errorexceptions.student.subject.Mark;
import javatasks.errorexceptions.student.subject.Subject;
import javatasks.errorexceptions.university.FacultyType;
import javatasks.errorexceptions.university.GroupType;
import javatasks.errorexceptions.university.IdType;
import javatasks.errorexceptions.university.UniversityType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Student implements ISubject {

    private IdType idType;
    private GroupType groupType;
    private FacultyType facultyType;
    private UniversityType universityType;
    protected String personUniqueName;
    private final List<Subject> subjectList = new ArrayList<>();

    public Student(String personUniqueNumber, String personUniqueName, String universityName, List<Mark> markList) {
        this.personUniqueName = personUniqueName;
        setSubjectList(markList);
        formIdType(personUniqueNumber, universityName);
    }

    public UniversityType getUniversityType() {
        return this.universityType;
    }

    public FacultyType getFacultyType() {
        return this.facultyType;
    }

    public GroupType getGroupType() {
        return this.groupType;
    }

    public List<Subject> getSubjectList() {
        return this.subjectList;
    }

    private void setSubjectList(List<? extends Subject> markList) {
        if (markList.size() != 0) {
            for (Subject subject : markList) {
                try {
                    addSubject(subject);
                } catch (IllegalArgumentException e) {
                    MarkOutOfBoundsException.getSubjectWithWrongInputData(e);
                }
            }
        }
    }

    public IdType getIdType() {
        return this.idType;
    }

    public String getPersonUniqueName() {
        return this.personUniqueName;
    }

    public abstract int getCounterPerson();

    public void formIdType(String personUniqueNumber, String universityName) {

        IdType idType = IdType.getIdTypeByPersonUniqueNumber(personUniqueNumber);
        boolean isUniversityType = false;
        if (idType != null) {
            isUniversityType = idType.getUniversityType().getRealUniversityName().equals(universityName);
        }

        if (isUniversityType && !idType.isFlagIdUsed()) {
            this.idType = idType;
            idType.setFlagIsIdUsed(true);
            idType.addSubjects(getSubjectList());
            this.groupType = idType.getGroupType();
            groupType.addStudent(this);
            this.facultyType = idType.getFacultyType();
            facultyType.addStudent(this);
            this.universityType = idType.getUniversityType();
            universityType.addStudent(this);
        } else {
            throw new IllegalArgumentException("personData several unique numbers : " + personUniqueNumber);
        }
        this.idType = idType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idType == student.idType &&
                groupType == student.groupType &&
                facultyType == student.facultyType &&
                universityType == student.universityType &&
                Objects.equals(personUniqueName, student.personUniqueName) &&
                Objects.equals(subjectList, student.subjectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, groupType, facultyType, universityType, personUniqueName, subjectList);
    }

    @Override
    public void addSubject(Subject subject) throws IllegalArgumentException {
        if (subject.getMark() > 0 && subject.getMark() <= 10) {
            this.subjectList.add(subject);
        } else {
            throw new IllegalArgumentException("\n" + getPersonUniqueName() + subject.toString());
        }
    }
}
