package java.errorexceptions.student;

import student.subject.Subject;

import java.util.List;

public interface IFormIdType {

    void formIdType(String personUniqueNumber, String universityName);

    void addSubjects(List<Subject> subjectList);
}
