package lotto.validator.exception;

public enum ErrorMessage {
    LOTTO_PURCHASE_IS_NOT_NUMBER("[ERROR] 구입 금액은 숫자만 입력하셔야 합니다."),
    LOTTO_PURCHASE_IS_NOT_THOUSAND_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력하셔야 합니다.");

    private final String errorMessage;
    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
