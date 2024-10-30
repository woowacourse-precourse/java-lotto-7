package lotto.constants;

public enum ErrorMessage {
    PURCHASE_MONEY_ONLY_CAN_NUMBER ("구입 금액은 숫자여야 합니다."),
    PURCHASE_MONEY_ONLY_CAN_THOUSAND_UNIT("구입 금액은 1,000원 단위여야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
