package javatasks.errorexceptions.university;


import javatasks.errorexceptions.student.Student;
import javatasks.errorexceptions.student.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public enum GroupType implements IStudent {
    G_126(FacultyType.ATF, UniversityType.BSPA),
    G_625(FacultyType.ATF, UniversityType.BSPA),
    G_626(FacultyType.MMF, UniversityType.BSPA);

    private FacultyType facultyType;
    private UniversityType universityType;
    private final List<Subject> subjectsList = new ArrayList<>();

    GroupType() {
    }

    GroupType(FacultyType facultyType, UniversityType universityType) {
        this.facultyType = facultyType;
        this.universityType = universityType;
    }

    public GroupType getGroupByCode(String groupName) {
        for (GroupType groupType : GroupType.values()) {
            if (groupType.toString().equals(groupName)) {
                return groupType;
            }
        }
        return null;
    }

    public FacultyType getFacultyType() {
        return this.facultyType;
    }

    public UniversityType getUniversityType() {
        return this.universityType;
    }

    public List<Subject> getSubjectsList() {
        return this.subjectsList;
    }

    @Override
    public void addStudent(Student student) {
        this.subjectsList.addAll(student.getSubjectList());
    }

    @Override
    public String toString() {
        return name().substring(2);
    }
}

