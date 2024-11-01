package lotto.exception;

public enum ErrorMessage {
    ;

    private static final String PREFIX = "[ERROR] ";
    private String message;

    public String getMessage() {
        return this.message;
    }

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }
}
