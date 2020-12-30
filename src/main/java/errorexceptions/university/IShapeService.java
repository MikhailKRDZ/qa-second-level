package errorexceptions.university;


import errorexceptions.student.subject.Subject;

import java.util.List;

@FunctionalInterface
public interface IShapeService {
    List<Subject> service(int... param);
}
