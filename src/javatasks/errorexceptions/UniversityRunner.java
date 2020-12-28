package javatasks.errorexceptions;


import javatasks.errorexceptions.customsexception.HandleException;
import javatasks.errorexceptions.student.data.Data;
import javatasks.errorexceptions.student.subject.SubjectType;
import javatasks.errorexceptions.university.*;

public class UniversityRunner {
    public static void main(String[] args) {
        Data data = new Data();
        HandleException.handleExceptions();

        University university = new University(data.personList);

        System.out.println(university.getStudents().toString());
        System.out.println("\n Average :" + University.subjectUniversityGetAverage(UniversityType.BSPA, SubjectType.CHEMISTRY) + "\n");
        System.out.println("\n Average :" + University.
                subjectFacultyGetAverage(FacultyType.MMF, SubjectType.CHEMISTRY) + "\n");
        System.out.println("\n Average :" + University.
                subjectGroupGetAverage(GroupType.G_625, SubjectType.ADVANCED_MATHEMATICS) + "\n");
        System.out.println("\n Average :" + University.idSubjectsGetAverage(IdType.ID_3) + "\n");
    }
}
