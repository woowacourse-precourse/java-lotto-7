package lotto.exception;

public enum LottoException {
    NUMBER_FORMAT_NOT_VALID("[ERROR] 숫자만 입력 가능합니다."),
    PURCHASE_AMOUNT_NOT_VALID("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    ;

    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
