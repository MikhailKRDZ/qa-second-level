package errorexceptions.university;


import errorexceptions.customsexception.GroupsWithoutStudentsException;
import errorexceptions.customsexception.NoSubjectsForTheStudent;
import errorexceptions.data.SubjectType;

import java.util.ArrayList;

public interface IUniversity {
    ArrayList<Subject> getSubjectList() throws IllegalArgumentException, NoSubjectsForTheStudent, GroupsWithoutStudentsException;
    double getAverage() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException;
    double getAverage(SubjectType subjectType) throws IllegalArgumentException, NoSubjectsForTheStudent, GroupsWithoutStudentsException;
}
