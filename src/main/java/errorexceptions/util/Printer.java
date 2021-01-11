package errorexceptions.util;


import errorexceptions.customsexception.GroupsWithoutStudentsException;
import errorexceptions.customsexception.NoSubjectsForTheStudent;
import errorexceptions.customsexception.UniversityWithoutFacultyException;
import errorexceptions.data.SubjectType;
import errorexceptions.university.*;

public class Printer {

    public static void printUniversityStructure(University university)
            throws UniversityWithoutFacultyException, GroupsWithoutStudentsException {
        System.out.println("университет: " + university.getRealUniversityName());
        for (Faculty faculty : university.getFacultyList()) {
            System.out.println("Факультет: " + faculty.getName());
            for (Group group : faculty.getGroupList()) {
                System.out.println("Группа: " + group.getName());
                for (Student student : group.getStudentList()) {
                    System.out.println("Студент: " + student.getName());
                }
            }
        }
    }

    public static void printAverageUniversity(University university, SubjectType subjectType)
            throws GroupsWithoutStudentsException, NoSubjectsForTheStudent, IllegalArgumentException,
            UniversityWithoutFacultyException {
        System.out.println("Средний балл Университета по предмету, " + subjectType.getSubjectRealName() + " : "
                + university.getAverage(subjectType));
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void printAverageFaculty(Faculty faculty, SubjectType subjectType)
            throws GroupsWithoutStudentsException, NoSubjectsForTheStudent, IllegalArgumentException {
        System.out.println("Средний балл факультета , " + faculty.getName() + ", по предмету, "
                + subjectType.getSubjectRealName() + " : " + faculty.getAverage(subjectType));
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void printAverageGroup(Group group, SubjectType subjectType)
            throws IllegalArgumentException, NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        System.out.println("Средний балл группы " + group.getName() + " по предмету, "
                + subjectType.getSubjectRealName() + " : " + group.getAverage(subjectType));
        System.out.println("------------------------------------------------------------------------------------");

    }

    public static void printAverageStudent(Student student) throws NoSubjectsForTheStudent {
        System.out.println("Средний балл студента " + student.getName() + " : " + student.getAverage());
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void printAllSubjects(University university)
            throws NoSubjectsForTheStudent, GroupsWithoutStudentsException, UniversityWithoutFacultyException {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("All university subjects");
        for (Subject subject : university.getSubjectList()) {
            System.out.println(subject.toString());
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void printAllSubjects(Faculty faculty) throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("All faculty subjects");
        for (Subject subject : faculty.getSubjectList()) {
            System.out.println(subject.toString());
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void printAllSubjects(Group group) throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("All group subjects");
        for (Subject subject : group.getSubjectList()) {
            System.out.println(subject.toString());
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void printAllSubjects(Student student) throws NoSubjectsForTheStudent {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("All student subjects");
        for (Subject subject : student.getSubjectList()) {
            System.out.println(subject.toString());
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
}
