package lotto.enums;

public enum ErrorMessage {
    BLANK_INPUT_NOT_ALLOWED("사용자 입력은 null, 빈문자열, 공백으로만 이루어진 문자열일 수 없습니다."),
    INVALID_INTEGER_INPUT("숫자는 정수 값만 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
