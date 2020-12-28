package javatasks.errorexceptions.university;


import javatasks.errorexceptions.student.Student;
import javatasks.errorexceptions.student.data.Person;
import javatasks.errorexceptions.student.subject.Subject;
import javatasks.errorexceptions.student.subject.SubjectType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University implements IStudent {
    private final ArrayList<Student> students = new ArrayList<>();

    public University(List<Person> personList) {
        for (Person person : personList) {
            addStudent(person);
        }
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(this.students);
    }

    public static double subjectUniversityGetAverage(UniversityType universityType, SubjectType subjectType) {
        System.out.print("Университет: " + universityType.getRealUniversityName());
        List<Subject> subjectList = universityType.getSubjectsList();
        double result = 0;
        if (subjectList.size() != 0) {
            System.out.print(" Предметы " + subjectList.toString());
            SubjectActionUniversity rectangleActionUniversity = new SubjectActionUniversity();
            System.out.print("\n Предмет: " + subjectType.getSubjectRealName());
            result = rectangleActionUniversity.action(SubjectParamUniversity.AVERAGE, subjectList, subjectType);
        }
        return result;
    }

    public static double subjectFacultyGetAverage(FacultyType facultyType, SubjectType subjectType) {
        System.out.print(" Факультет: " + facultyType.getRealFacultyName());
        List<Subject> subjectList = facultyType.getSubjectsList();
        double result = 0;
        if (subjectList.size() != 0) {
            System.out.print("\n Предметы: " + subjectList.toString());
            SubjectActionUniversity rectangleActionUniversity = new SubjectActionUniversity();
            System.out.print("\n Предмет: " + subjectType.getSubjectRealName());
            result = rectangleActionUniversity.action(SubjectParamUniversity.AVERAGE, subjectList, subjectType);
        }
        return result;
    }

    public static double subjectGroupGetAverage(GroupType groupType, SubjectType subjectType) {
        System.out.print(" Группа: " + groupType.toString());
        List<Subject> subjectList = groupType.getSubjectsList();
        double result = 0;
        if (subjectList.size() != 0) {
            System.out.print("\n Предметы: " + subjectList.toString());
            SubjectActionUniversity rectangleActionUniversity = new SubjectActionUniversity();
            System.out.print(" \n Предмет: " + subjectType.getSubjectRealName());
            result = rectangleActionUniversity.action(SubjectParamUniversity.AVERAGE, subjectList, subjectType);
        }
        return result;
    }

    public static double idSubjectsGetAverage(IdType idType) {
        System.out.print(" Id: " + idType + ", personId: " + idType.getStudentsIdTypeRealName() + ", Предметы: ");
        List<Subject> subjectList = idType.getIdSubjectsList();
        double result = 0;
        if (subjectList.size() != 0) {
            SubjectActionUniversity rectangleActionUniversity = new SubjectActionUniversity();
            result = rectangleActionUniversity.action(SubjectParamUniversity.AVERAGE, subjectList);
        }
        return result;
    }

    @Override
    public void addStudent(Student student) {
        this.students.add(student);
    }
}
