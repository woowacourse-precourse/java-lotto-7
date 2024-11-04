package lotto.validation;

public enum ValidationType {
    EMPTY_AMOUNT("[ERROR]구입금액이 입력되지 않았습니다.");

    ValidationType(String validationMsg) {
        this.validationMsg = validationMsg;
    }

    private final String validationMsg;

    public String validationMsg() {
        return validationMsg;
    }
}
