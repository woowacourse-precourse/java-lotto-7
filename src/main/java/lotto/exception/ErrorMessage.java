package lotto.exception;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),

    INPUT_BLANK("입력값이 비어있습니다."),
    INPUT_NOT_DIGIT("시도 횟수는 정수여야 합니다."),

    LOTTO_NUMBER_NOT_DIGIT("로또 번호는 정수여야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1~45 범위의 정수여야 합니다."),
    LOTTO_NUMBER_COUNT_NOT_MATCHED("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호는 중복되지 않아야 합니다."),

    PURCHASE_AMOUNT_NOT_ENOUGH("구매 금액은 최소 1000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_NOT_DIVISIBLE("구매 금액은 1000원 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
