package errorexceptions.university;


import errorexceptions.customsexception.NoSubjectsForTheStudent;
import errorexceptions.data.SubjectType;

import java.util.ArrayList;

public class Student implements IUniversity {
    private final String realIdTypeName;
    private final ArrayList<Subject> subjectList;

    public Student() {
        this(null);
    }

    public Student(String studentsIdTypeRealName) {
        this.realIdTypeName = studentsIdTypeRealName;
        this.subjectList = new ArrayList<>();
    }

    public void addSubject(Subject subject) throws IllegalArgumentException {
        for (Subject subject1 : this.subjectList) {
            if (subject1.getName().equals(subject.getName())) {
                throw new IllegalArgumentException("wrong Subject " + this.realIdTypeName);
            }
        }
        this.subjectList.add(subject);
    }

    public ArrayList<Subject> getSubjectList() throws NoSubjectsForTheStudent {
        if (this.subjectList.isEmpty())
            throw new NoSubjectsForTheStudent(" No Subjects in Students" + this.realIdTypeName);
        return this.subjectList;
    }

    public double getAverage() {
        int sum = 0;
        int number = 0;
        for (Subject subject : this.subjectList) {
            sum = sum + subject.getMark();
            number = number + 1;
        }
        return (double) sum / number;
    }

    @Override
    public double getAverage(SubjectType subjectType) {
        return 0;
    }

    public String getName() {
        return realIdTypeName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "realIdTypeName='" + realIdTypeName + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
