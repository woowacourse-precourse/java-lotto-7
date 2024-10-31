package lotto.exception;

public enum ExceptionMessage {

    BLANK_INPUT_EXCEPTION("빈 문자열은 입력할 수 없습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
