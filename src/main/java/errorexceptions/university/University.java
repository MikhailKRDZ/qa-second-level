package errorexceptions.university;

import errorexceptions.customsexception.GroupsWithoutStudentsException;
import errorexceptions.customsexception.NoSubjectsForTheStudent;
import errorexceptions.customsexception.UniversityWithoutFacultyException;
import errorexceptions.data.SubjectType;

import java.util.ArrayList;
import java.util.List;

public class University implements IUniversity {
    private final String realUniversityName;
    private final List<Faculty> facultyList;

    public University() {
        this(null);
    }

    public University(String universityName) {
        this.realUniversityName = universityName;
        this.facultyList = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) throws IllegalArgumentException {
        for (Faculty addedFaculty : this.facultyList) {
            if (addedFaculty.getName().equals(faculty.getName())) {
                throw new IllegalArgumentException("wrong faculty" + faculty.getName());
            }
        }
        this.facultyList.add(faculty);
    }

    public String getRealUniversityName() {
        return realUniversityName;
    }

    public List<Faculty> getFacultyList() throws UniversityWithoutFacultyException {
        if (this.facultyList.isEmpty()) {
            throw new UniversityWithoutFacultyException(" No Faculties in University");
        }
        return this.facultyList;
    }

    public Faculty getFaculty(String reqFacultyName) throws UniversityWithoutFacultyException, IllegalArgumentException {
        if (this.facultyList.isEmpty()) {
            throw new UniversityWithoutFacultyException(" No Faculties in University");
        }
        for (Faculty faculty : this.facultyList) {
            if (faculty.getName().equals(reqFacultyName)) {
                return faculty;
            }
        }
        throw new IllegalArgumentException("No faculty in University " + this.realUniversityName + "  with this Name" + reqFacultyName);
    }

    @Override
    public ArrayList<Subject> getSubjectList() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        ArrayList<Subject> subjectArrayList;
        subjectArrayList = new ArrayList<>();
        for (Faculty faculty : this.facultyList) {
            for (Group group : faculty.getGroupList()) {
                for (Student student : group.getStudentList()) {
                    subjectArrayList.addAll(student.getSubjectList());
                }
            }
        }
        return subjectArrayList;
    }

    @Override
    public double getAverage() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        int sum = 0;
        int number = 0;
        for (Subject subject : getSubjectList()) {
            sum = sum + subject.getMark();
            number = number + 1;
        }
        return (double) sum / number;
    }

    @Override
    public double getAverage(SubjectType subjectType) throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        int sum = 0;
        int number = 0;
        for (Subject subject : getSubjectList()) {
            if (subject.getName().equals(subjectType.getSubjectRealName())) {
                sum = sum + subject.getMark();
                number = number + 1;
            }
        }
        return (double) sum / number;
    }

    @Override
    public String toString() {
        return "University{" +
                "realUniversityName='" + realUniversityName + '\'' +
                ", facultyList=" + facultyList +
                '}';
    }
}