package lotto.exception;

public enum ExceptionMessage {

    INPUT_BLANK("[ERROR] 값을 입력하지 않으셨습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
