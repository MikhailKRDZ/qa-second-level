package javatasks.errorexceptions.student.subject;

import java.util.Objects;

public abstract class Subject {
    private SubjectType subjectType;
    private int subjectMark;

    public Subject(SubjectType subjectType, int subjectMark) {
        this.subjectType = subjectType;
        this.subjectMark = subjectMark;
    }

    public Subject(String marksName, int mark) {
        setSubjectType(marksName);
        setSubjectMark(mark);
    }

    public void setSubjectType(String marksName) {
        SubjectType subjectType = SubjectType.getSubjectValueByRealName(marksName);
        if (subjectType != null) {
            this.subjectType = subjectType;
        }
    }

    public void setSubjectMark(int mark) {
        this.subjectMark = mark;
    }

    public SubjectType getSubjectType() {
        return this.subjectType;
    }

    public String getMarksName() {
        return this.subjectType.getSubjectRealName();
    }

    public int getMark() {
        return this.subjectMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectMark == subject.subjectMark &&
                subjectType == subject.subjectType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectType, subjectMark);
    }
}
