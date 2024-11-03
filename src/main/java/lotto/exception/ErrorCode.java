package lotto.exception;

public enum ErrorCode {
    // INVALID_ARGUMENT
    INVALID_NEGATIVE_NUMBER("음수를 입력할 수 없습니다"),
    INVALID_AMOUNT_FORMAT("금액은 숫자만 입력 가능합니다."),
    INVALID_PRICE_UNIT("금액은 1000원 단위만 허용됩니다."),
    INVALID_LOTTO_NUMBERS_COUNT("로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
