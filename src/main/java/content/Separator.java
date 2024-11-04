package content;

public enum Separator {
    RESULT_SEPARATOR("---"),
    WINNING_SEPARATOR(",");


    private final String message;

    public String getMessage() {
        return message;
    }

    Separator(String message) {
        this.message = message;
    }
}
