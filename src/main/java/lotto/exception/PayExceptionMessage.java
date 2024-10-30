package lotto.exception;

public enum PayExceptionMessage {

    PAY_BOUNDED_EXCEPTION("금액은 반드시 1000원 이상이여야 합니다.");

    private final String errorMessage;

    PayExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
