package errorexceptions;


import errorexceptions.customsexception.CustomsExceptions;
import errorexceptions.data.SubjectType;
import errorexceptions.university.Faculty;
import errorexceptions.university.Group;
import errorexceptions.university.Student;
import errorexceptions.university.University;
import errorexceptions.util.GeneratorData;
import errorexceptions.util.Printer;

public class UniversityRunner {

    public static void main(String[] args) {
        try {
            University university = GeneratorData.generateRequiredData(3, 4,
                    5, 6);

            Printer.printUniversityStructure(university);
            Printer.printAllSubjects(university);

            SubjectType subjectType = SubjectType.CHEMISTRY;
            Printer.printAverageUniversity(university, subjectType);

            Faculty faculty = university.getFaculty("ММФ");
            Printer.printAllSubjects(faculty);
            Printer.printAverageFaculty(faculty, subjectType);

            Group group = university.getFaculty("ММФ").getGroupList().get(1);
            Printer.printAllSubjects(group);
            Printer.printAverageGroup(group, subjectType);

            Student student = university.getFaculty("ММФ").getGroupList().get(2).getStudentList().get(2);
            Printer.printAllSubjects(student);
            Printer.printAverageStudent(student);

        } catch (CustomsExceptions e) {
            e.printStackTrace();
        }
    }


}