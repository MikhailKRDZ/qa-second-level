package errorexceptions.university;


import errorexceptions.customsexception.GroupsWithoutStudentsException;
import errorexceptions.customsexception.NoSubjectsForTheStudent;
import errorexceptions.data.SubjectType;

import java.util.ArrayList;

public class Group implements IUniversity {
    private final String realGroupName;
    private final ArrayList<Student> studentList;

    public Group() {
        this(null);
    }

    public Group(String realGroupName) {
        this.realGroupName = realGroupName;
        this.studentList = new ArrayList<>();

    }

    public void addStudent(Student student) throws IllegalArgumentException {
        for (Student addedStudent : this.studentList) {
            if (addedStudent.getName().equals(student.getName())) {
                throw new IllegalArgumentException("student with this name exist, student: " + student.getName());
            }
        }
        this.studentList.add(student);
    }

    public String getName() {
        return this.realGroupName;
    }

    public ArrayList<Student> getStudentList() throws GroupsWithoutStudentsException {
        if (this.studentList.isEmpty()) {
            throw new GroupsWithoutStudentsException(" No Students in Group " + this.realGroupName);
        }
        return this.studentList;
    }

    public Student getStudent(String studentsIdTypeRealName) throws GroupsWithoutStudentsException, IllegalArgumentException {
        if (this.studentList.isEmpty()) {
            throw new GroupsWithoutStudentsException(" No Students in Group " + this.realGroupName);
        }
        for (Student student : this.studentList) {
            if (student.getName().equals(studentsIdTypeRealName)) {
                return student;
            }
        }
        throw  new IllegalArgumentException("No student in Group  " + this.realGroupName + "  with this Name" + studentsIdTypeRealName);
    }

    @Override
    public ArrayList<Subject> getSubjectList() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        for (Student student : getStudentList()) {
            subjectArrayList.addAll(student.getSubjectList());
        }
        return subjectArrayList;
    }

    public double getAverage() throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        int sum = 0;
        for (Subject subject : getSubjectList()) {
                sum = sum + subject.getMark();
        }
        return (double) sum / getSubjectList().size();
    }

    @Override
    public double getAverage(SubjectType subjectType) throws NoSubjectsForTheStudent, GroupsWithoutStudentsException {
        int sum = 0;
        int subjectNumber = 0;
            for (Subject subject : getSubjectList()) {
                if (subject.getName().equals(subjectType.getSubjectRealName())) {
                    sum = sum + subject.getMark();
                    subjectNumber++;
                }
            }
        return (double) sum / subjectNumber;
    }

    @Override
    public String toString() {
        return "Group{" +
                "realGroupName='" + realGroupName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
