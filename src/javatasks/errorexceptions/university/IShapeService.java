package javatasks.errorexceptions.university;


import javatasks.errorexceptions.student.subject.Subject;

import java.util.List;

@FunctionalInterface
public interface IShapeService {
    List<Subject> service(int... param);
}
