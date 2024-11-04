package lotto.error.format;

public enum ErrorMessageFormat {

    PREFIX("[ERROR] ");

    private final String message;

    ErrorMessageFormat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
