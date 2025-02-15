package lotto.exception;

public class RetryInputException extends IllegalArgumentException {
    private final String viewMessage;

    public RetryInputException(String viewMessage, String message) {
        super(message);
        this.viewMessage = viewMessage;
    }

    public String getViewMessage() {
        return viewMessage;
    }
}
