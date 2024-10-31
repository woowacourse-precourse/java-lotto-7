package lotto.exception;

public class CustomException extends IllegalArgumentException {
    private static final String HEADER = "[ERROR] ";

    public CustomException(String message) {
        super(HEADER + message);
    }
}
