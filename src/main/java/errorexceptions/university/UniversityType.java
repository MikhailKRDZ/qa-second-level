package errorexceptions.university;



import errorexceptions.student.Student;
import errorexceptions.student.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public enum UniversityType implements IStudent {

    BSPA("БГПА"),
    ;

    private final String realUniversityName;
    private final List<Subject> subjectsList = new ArrayList<>();

    UniversityType() {
        this.realUniversityName = getRealUniversityName();
    }

    UniversityType(String realUniversityName) {
        this.realUniversityName = realUniversityName;
    }

    public String getRealUniversityName() {
        return this.realUniversityName;
    }

    public List<Subject> getSubjectsList() {
        return this.subjectsList;
    }

    @Override
    public void addStudent(Student student) {
        this.subjectsList.addAll(student.getSubjectList());
    }
}
