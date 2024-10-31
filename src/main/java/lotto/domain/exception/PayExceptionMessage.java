package lotto.domain.exception;

public enum PayExceptionMessage {

    PAY_BOUNDED_EXCEPTION("[ERROR] 금액은 반드시 1000원 이상이여야 합니다."),
    PAY_DIVISIBLE_EXCEPTION("[ERROR] 금액은 반드시 1000원으로 나누어 떨어져야 합니다."),
    PAY_ACCESS_NUMBER("[ERROR] 금액은 숫자만 입력 가능합니다.");

    private final String errorMessage;

    PayExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
