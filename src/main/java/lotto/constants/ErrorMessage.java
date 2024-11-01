package lotto.constants;

public enum ErrorMessage {
    INPUT_EMPTY("입력이 없거나 공백이어선 안됩니다."),
    NOT_INTEGER("입력은 정수여야 합니다."),
    NOT_POSITIVE("입력은 양수여야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG + message;
    }
}