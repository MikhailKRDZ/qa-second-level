package java.errorexceptions.customsexception;

import university.FacultyType;
import university.GroupType;
import university.IdType;

import java.util.ArrayList;

public class HandleException {

    public static void handleExceptions() {
        try {
            getStudentsWithoutSubjects();
            getGroupsWithoutStudents();
            getFacultiesWithoutGroup();
            getFacultiesWithoutStudents();
        } catch (CustomsExceptions e) {
            printStack(e);
        }
        try {
            getGroupsWithoutStudents();
            getFacultiesWithoutGroup();
            getFacultiesWithoutStudents();
        } catch (CustomsExceptions e) {
            printStack(e);
        }
        try {
            getFacultiesWithoutGroup();
            getFacultiesWithoutStudents();
        } catch (CustomsExceptions e) {
            printStack(e);
        }
        try {
            getFacultiesWithoutStudents();
        } catch (CustomsExceptions e) {
            printStack(e);
        }
    }

    public static void printStack(Throwable throwable) {
        System.err.println(throwable);
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.err.println(element);
        }
    }

    public static void getStudentsWithoutSubjects() throws NoSubjectsForTheStudent {
        ArrayList<String> studentsWithoutSubjects = new ArrayList<>();
        for (IdType idType : IdType.values()) {
            if (idType.getIdSubjectsList().size() == 0) {
                studentsWithoutSubjects.add(idType.getStudentsIdTypeRealName());
            }
        }
        if (studentsWithoutSubjects.size() != 0) {
            throw new NoSubjectsForTheStudent(studentsWithoutSubjects.toString());
        }
    }

    public static void getGroupsWithoutStudents() throws GroupsWithoutStudentsException {
        ArrayList<String> groupsWithoutStudents = new ArrayList<>();
        for (GroupType groupType : GroupType.values()) {
            if (groupType.getSubjectsList().size() == 0) {
                groupsWithoutStudents.add(groupType.toString());
            }
            if (groupsWithoutStudents.size() != 0) {
                throw new GroupsWithoutStudentsException(groupsWithoutStudents.toString());
            }
        }
    }

    public static void getFacultiesWithoutGroup() throws FacultyHasInsufficientGroupsException {
        ArrayList<String> facultiesWithoutGroup = new ArrayList<>();
        for (GroupType groupType : GroupType.values()) {
            if (groupType.getSubjectsList().size() == 0) {
                facultiesWithoutGroup.add(groupType.getFacultyType().toString());
            }
        }
        if (facultiesWithoutGroup.size() != 0) {
            throw new FacultyHasInsufficientGroupsException(facultiesWithoutGroup.toString());
        }
    }

    public static void getFacultiesWithoutStudents() throws UniversityWithoutFacultyException {
        ArrayList<String> facultyWithoutStudents = new ArrayList<>();
        for (FacultyType facultyType : FacultyType.values()) {
            if (facultyType.getSubjectsList().size() == 0) {
                facultyWithoutStudents.add(facultyType.getRealFacultyName());
            }
        }
        if (facultyWithoutStudents.size() != 0) {
            throw new UniversityWithoutFacultyException(facultyWithoutStudents.toString());
        }
    }
}
