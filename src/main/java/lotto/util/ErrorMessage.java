package lotto.util;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어 있습니다."),
    NON_NUMBER("int 범위의 정수값으로 입력해야 합니다.");

    private static final String ERROR_START = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_START + message;
    }
}