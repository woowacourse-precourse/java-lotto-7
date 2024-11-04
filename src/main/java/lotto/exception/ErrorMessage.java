package lotto.exception;

public enum ErrorMessage {
    ERROR_MESSAGE_PREFIX("[ERROR] "),
    CONTAIN_BLANK("공백을 포함한 문자열은 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE_PREFIX.message + message;
    }
}
