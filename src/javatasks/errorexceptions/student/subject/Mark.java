package java.errorexceptions.student.subject;


public class Mark extends Subject {
    private int mark;

    public Mark(String markSubjectName, int mark) throws IllegalArgumentException {
        super(markSubjectName, mark);
        this.mark = mark;
    }

    public int getMark() {
        return this.mark;
    }

    public String getMarksName() {
        return super.getMarksName();
    }

    @Override
    public String toString() {
        return "\n Subject{" +
                "\t name= " + getMarksName() + "," +
                "\t mark= " + getMark() +
                "}";
    }
}
