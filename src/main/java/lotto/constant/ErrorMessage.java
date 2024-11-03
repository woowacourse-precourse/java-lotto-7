package lotto.constant;

public enum ErrorMessage {
    INVALID_POSITIVE_INTEGER("%s 구입금액은 양수로 입력해주세요."),
    INVALID_PAYMENT_UNIT("%s 구입 금액은 1,000원 단위로 입력할 수 있습니다.");

    private static final String ERROR_HEADER = "[ERROR]";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(message, ERROR_HEADER);
    }
}
