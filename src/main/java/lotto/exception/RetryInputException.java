package lotto.exception;

public class RetryInputException extends IllegalArgumentException {
    private final String viewMessage;

    public RetryInputException(String message, String viewMessage) {
        super(message);
        this.viewMessage = viewMessage;
    }

    public String getViewMessage() {
        return viewMessage;
    }
}
