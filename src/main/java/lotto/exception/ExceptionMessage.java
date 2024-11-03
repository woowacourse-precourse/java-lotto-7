package lotto.exception;

public enum ExceptionMessage {
    TOO_MANY_NUMBERS("로또 번호는 6개여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
