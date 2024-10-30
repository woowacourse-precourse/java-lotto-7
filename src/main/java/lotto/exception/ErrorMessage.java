package lotto.exception;

public enum ErrorMessage {
    // 공용
    INPUT_EMPTY_ERROR("빈 입력입니다."),

    // 구입 금액
    PURCHASE_AMOUNT_NOT_DIVISIBLE("구입 금액은 %d원으로 나누어 떨어져야 합니다."),
    PURCHASE_AMOUNT_NOT_NUMBER("구입 금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_OUT_OF_RANGE("구입 금액은 %d이상의 정수여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
