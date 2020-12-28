package java.errorexceptions.customsexception;

public class CustomsExceptions extends Exception {

    public CustomsExceptions() {
    }

    public CustomsExceptions(String message) {
        super(message);
    }

    public CustomsExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomsExceptions(Throwable cause) {
        super(cause);
    }


}
