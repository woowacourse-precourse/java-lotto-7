package lotto.validation;

public enum ValidationType {
    EMPTY_AMOUNT("[ERROR]구입금액이 입력되지 않았습니다."),
    NOT_NUMERIC("[ERROR]구입 금액은 숫자여야 합니다."),
    NEGATIVE_AMOUNT("[ERROR]구입 금액은 양수여야 합니다."),
    INVALID_UNIT("[ERROR]구입 금액은 1,000원 단위여야 합니다.");

    ValidationType(String validationMsg) {
        this.validationMsg = validationMsg;
    }

    private final String validationMsg;

    public String validationMsg() {
        return validationMsg;
    }
}
