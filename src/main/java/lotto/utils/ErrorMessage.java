package lotto.utils;

public enum ErrorMessage {
    EMPTY_INPUT_ERROR_MESSAGE("빈 문자열 및 공백은 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
