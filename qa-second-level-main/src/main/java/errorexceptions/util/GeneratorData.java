package errorexceptions.util;


import errorexceptions.universitycustomsexception.MarkOutOfBoundsException;
import errorexceptions.data.SubjectType;
import errorexceptions.university.*;

import java.util.concurrent.ThreadLocalRandom;

public class GeneratorData {
    public static final String[] FACULTY_NAMES = {"АТФ", "ММФ", "ПСФ", "АФ"};
    public static final String[] GROUP_NAMES = {"126", "127", "128", "129", "130", "131", "132", "133", "134", "625", "626", "627", "628", "629"};
    public static final String[] STUDENT_NAMES = {"BY1001", "BY1002", "BY1003", "BY1004", "BY1005", "BY1006",
            "BY1007", "BY1008", "BY1009", "BY1010", "BY1011", "BY1012", "BY1013", "BY1014", "BY1015", "BY1016", "BY1017",
            "BY1018", "BY1019", "BY1020", "BY1021", "BY1022", "BY1023", "BY1024", "BY1025"};
    public static final SubjectType[] SUBJECT_NAMES = SubjectType.values();

    public static University generateRequiredData(int numberFacultiesInUniversity, int numberGroupsInFaculty,
                                                  int numberStudentsInGroup, int numberSubjectsInStudent) {
        University university = new University("БГПА");
        for (int i = 0; i < numberFacultiesInUniversity; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, FACULTY_NAMES.length);
            Faculty faculty = new Faculty(FACULTY_NAMES[randomNum]);

            for (int j = 0; j < numberGroupsInFaculty; j++) {
                int randomGroup = ThreadLocalRandom.current().nextInt(0, GROUP_NAMES.length);
                Group group = new Group(GROUP_NAMES[randomGroup]);


                for (int k = 0; k < numberStudentsInGroup; k++) {
                    int randomStudent = ThreadLocalRandom.current().nextInt(0, STUDENT_NAMES.length);
                    Student student = new Student(STUDENT_NAMES[randomStudent]);

                    for (int l = 0; l < numberSubjectsInStudent; l++) {
                        int randomSubject = ThreadLocalRandom.current().nextInt(0, SUBJECT_NAMES.length);
                        int randomSubjectsMark = ThreadLocalRandom.current().nextInt(1, 10);

                        Subject subject = null;
                        try {
                            subject = new Subject(student.getName(), SUBJECT_NAMES[randomSubject].getSubjectRealName(), randomSubjectsMark);
                        } catch (MarkOutOfBoundsException exceptions) {
                            exceptions.printStackTrace();
                            l--;
                        }
                        try {
                            student.addSubject(subject);
                        } catch (IllegalArgumentException exception) {
                            System.err.println(exception.getMessage());
                            l--;
                        }
                    }
                    try {
                        group.addStudent(student);
                    } catch (IllegalArgumentException exceptions) {
                        System.err.println(exceptions.getMessage());
                        k--;
                    }
                }
                try {
                    faculty.addGroup(group);
                } catch (IllegalArgumentException exception) {
                    System.err.println(exception.getMessage());
                    j--;
                }
            }
            try {
                university.addFaculty(faculty);
            } catch (IllegalArgumentException exceptions) {
                System.err.println(exceptions.getMessage());
                i--;
            }
        }
        return university;
    }

    public static University generateRandomData(int numberFacultiesInUniversity, int numberGroupsInFaculty,
                                                int numberStudentsInGroup, int numberSubjectsInStudent) {
        University university = new University("БГПА");
        for (int i = 0; i < numberFacultiesInUniversity; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, FACULTY_NAMES.length);
            Faculty faculty = new Faculty(FACULTY_NAMES[randomNum]);

            for (int j = 0; j < numberGroupsInFaculty; j++) {
                int randomGroup = ThreadLocalRandom.current().nextInt(0, GROUP_NAMES.length);
                Group group = new Group(GROUP_NAMES[randomGroup]);


                for (int k = 0; k < numberStudentsInGroup; k++) {
                    int randomStudent = ThreadLocalRandom.current().nextInt(0, STUDENT_NAMES.length);
                    Student student = new Student(STUDENT_NAMES[randomStudent]);

                    for (int l = 0; l < numberSubjectsInStudent; l++) {
                        int randomSubject = ThreadLocalRandom.current().nextInt(0, SUBJECT_NAMES.length);
                        int randomSubjectsMark = ThreadLocalRandom.current().nextInt(1, 10);

                        Subject subject = null;
                        try {
                            subject = new Subject(student.getName(), SUBJECT_NAMES[randomSubject].getSubjectRealName(), randomSubjectsMark);
                        } catch (MarkOutOfBoundsException exceptions) {
                            exceptions.printStackTrace();
                        }
                        try {
                            student.addSubject(subject);
                        } catch (IllegalArgumentException exception) {
                            System.err.println(exception.getMessage());
                        }
                    }
                    try {
                        group.addStudent(student);
                    } catch (IllegalArgumentException exceptions) {
                        System.err.println(exceptions.getMessage());
                    }
                }
                try {
                    faculty.addGroup(group);
                } catch (IllegalArgumentException exception) {
                    System.err.println(exception.getMessage());
                }
            }
            try {
                university.addFaculty(faculty);
            } catch (IllegalArgumentException exceptions) {
                System.err.println(exceptions.getMessage());
            }
        }
        return university;
    }
}
