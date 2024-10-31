package lotto.Exception;

public abstract class CustomException extends IllegalArgumentException {
    private static final String HEADER = "[ERROR] ";
    private static String MESSAGE;

    public CustomException() {
        super(HEADER + MESSAGE);
    }
}
