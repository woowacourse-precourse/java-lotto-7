package lotto.exception;

public enum ErrorCode {
    // INVALID_ARGUMENT
    INVALID_NEGATIVE_NUMBER("음수를 입력할 수 없습니다"),
    INVALID_AMOUNT_FORMAT("금액은 숫자만 입력 가능합니다.");


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
