package errorexceptions.university;


import errorexceptions.customsexception.MarkOutOfBoundsException;

public class Subject {
    private final String subjectName;
    private final String personId;
    private int mark;

    public Subject(String personId, String subjectName, int mark) throws MarkOutOfBoundsException {
        this.personId = personId;
        this.subjectName = subjectName;
        setSubjectMark(mark);
    }

    private void setSubjectMark(int mark) throws MarkOutOfBoundsException {
        if (mark > 10 || mark <= 0) {
            throw new MarkOutOfBoundsException("Mark:" + mark + ", out of real value");
        }
        this.mark = mark;
    }

    public String getName() {
        return this.subjectName;
    }

    public int getMark() {
        return this.mark;
    }

    public String getPersonId() {
        return personId;
    }

    @Override
    public String toString() {
        return personId + "  " + subjectName + "  " + mark;
    }
}
