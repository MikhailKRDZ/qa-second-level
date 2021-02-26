package errorexceptions.university;


import errorexceptions.data.SubjectType;
import errorexceptions.universitycustomsexception.GroupsWithoutStudentsException;
import errorexceptions.universitycustomsexception.NoSubjectsForTheStudent;
import errorexceptions.universitycustomsexception.UniversityWithoutFacultyException;

import java.util.ArrayList;

public interface IUniversity {
    ArrayList<Subject> getSubjectList() throws IllegalArgumentException, NoSubjectsForTheStudent,
            GroupsWithoutStudentsException, UniversityWithoutFacultyException;
    double getAverage() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException, UniversityWithoutFacultyException;
    double getAverage(SubjectType subjectType) throws IllegalArgumentException, NoSubjectsForTheStudent,
            GroupsWithoutStudentsException, UniversityWithoutFacultyException;
}
