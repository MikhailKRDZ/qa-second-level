package errorexceptions.customsexception;

public class MarkOutOfBoundsException extends CustomsExceptions {
    public MarkOutOfBoundsException() {
    }

    public static void getSubjectWithWrongInputData(IllegalArgumentException illegalArgumentException) {
        try {
            throw new CustomsExceptions(illegalArgumentException);
        } catch (CustomsExceptions e) {
            e.printStackTrace();
        }
    }
}
