package lotto.enums;

public enum ErrorCode {
    PURCHASE_AMOUNT_MUST_BE_NUMBER("구입 금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000("구입 금액은 1000 단위여야 합니다."),
    PURCHASE_AMOUNT_BELOW_MINIMUM("구입 금액은 로또 한장의 가격 이상이어야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    ;

    private final String message;
    private static final String ERROR = "[ERROR] ";

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
