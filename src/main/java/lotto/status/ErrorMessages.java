package lotto.status;

public enum ErrorMessages {
    DUPLICATE_NUMBER("중복된 숫자가 있습니다."),
    EMPTY_VALUE("아무것도 입력하지 않았습니다."),
    NON_POSITIVE_NUMERIC("양의 정수만 입력해 주세요"),
    INVALID_FORMAT("입력형식이 옳바르지 않습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
