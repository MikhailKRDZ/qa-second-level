package java.errorexceptions.university;


import student.subject.Subject;
import student.subject.SubjectType;

import java.util.List;

public class SubjectActionUniversity {
    public Double action(SubjectParamUniversity param, List<Subject> subjectList, SubjectType subjectType) {
        double sum = 0;
        int count = 0;
        for (Subject subject : subjectList) {

            if (subject.getSubjectType() == subjectType) {
                System.out.print(subject.toString());
                sum += subject.getMark();
                count++;
            }
        }
        return param.get().apply(sum, count);
    }

    public Double action(SubjectParamUniversity param, List<Subject> subjectList) {
        double sum = 0;
        for (Subject subject : subjectList) {
            System.out.print(subject.toString());
            sum += subject.getMark();
        }
        return param.get().apply(sum, subjectList.size());
    }
}
