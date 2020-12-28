package javatasks.errorexceptions.student;


import javatasks.errorexceptions.student.subject.Subject;

import java.util.List;

public interface IFormIdType {

    void formIdType(String personUniqueNumber, String universityName);

    void addSubjects(List<Subject> subjectList);
}
