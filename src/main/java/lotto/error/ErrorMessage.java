package lotto.error;

public enum ErrorMessage {

    PREFIX("[ERROR] ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
