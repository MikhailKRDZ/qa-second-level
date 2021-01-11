package errorexceptions.universitycustomsexception;

public class MarkOutOfBoundsException extends CustomsExceptions {
    public MarkOutOfBoundsException(String message) {
        super(message);
    }

//    public static void getSubjectWithWrongInputData(IllegalArgumentException illegalArgumentException) {
//        try {
//            throw new CustomsExceptions(illegalArgumentException);
//        } catch (CustomsExceptions e) {
//            e.printStackTrace();
//        }
//    }
}
