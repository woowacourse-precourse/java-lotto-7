package lotto.validation;

public enum ValidationType {
    EMPTY_AMOUNT("[ERROR]구입금액이 입력되지 않았습니다."),
    NOT_NUMERIC("[ERROR]구입 금액은 숫자여야 합니다."),
    NEGATIVE_AMOUNT("[ERROR]구입 금액은 양수여야 합니다."),
    INVALID_UNIT("[ERROR]구입 금액은 1,000원 단위여야 합니다."),
    OUT_OF_RANGE("[ERROR]당첨 번호는 1에서 45 사이여야 합니다."),
    DUPLICATE_NUMBERS("[ERROR]당첨 번호는 중복될 수 없습니다."),
    INVALID_COUNT("[ERROR]당첨 번호는 6개여야 합니다."),
    INVALID_FORMAT("[ERROR]당첨 번호는 6개의 쉼표로 구분되어야 합니다.");

    ValidationType(String validationMsg) {
        this.validationMsg = validationMsg;
    }

    private final String validationMsg;

    public String validationMsg() {
        return validationMsg;
    }
}
