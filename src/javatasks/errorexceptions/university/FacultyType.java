package javatasks.errorexceptions.university;


import javatasks.errorexceptions.student.Student;
import javatasks.errorexceptions.student.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public enum FacultyType implements IStudent {

    ATF("АТФ", UniversityType.BSPA),
    MMF("ММФ", UniversityType.BSPA),
    ;

    private String realFacultyName;
    private final List<Subject> subjectsList = new ArrayList<>();
    private final UniversityType universityType;


    FacultyType(UniversityType universityType) {
        this.universityType = universityType;
    }

    FacultyType(String realFacultyName, UniversityType universityType) {
        this.realFacultyName = realFacultyName;
        this.universityType = universityType;
    }

    public String getRealFacultyName() {
        return this.realFacultyName;
    }

    public List<Subject> getSubjectsList() {
        return this.subjectsList;
    }

    public UniversityType getUniversityType() {
        return this.universityType;
    }

    @Override
    public String toString() {
        return getRealFacultyName();
    }

    @Override
    public void addStudent(Student student) {
        this.subjectsList.addAll(student.getSubjectList());
    }
}


