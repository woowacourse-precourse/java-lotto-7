package lotto.exception;

public enum NumberErrorCode {
    NUMBER_PARSE_ERROR("당첨번호는 숫자여야 합니다"),
    ;

    private final String message;

    NumberErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
