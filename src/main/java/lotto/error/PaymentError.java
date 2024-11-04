package lotto.error;

import lotto.error.format.ErrorMessageFormat;

public enum PaymentError {

    NEGATIVE_PAYMENT("구입 금액은 음이 아닌 정수를 입력해주세요."),
    EXCEED_MAX_PAYMENT("구입 금액이 너무 큽니다."),
    WRONG_PAYMENT_FORMAT("구입 금액이 잘못된 형식입니다."),
    NOT_MULTIPLE_OF_THOUSAND_PAYMENT("구입 금액은 1000의 배수로 입력해주세요.");

    private final String message;
    private final String prefix = ErrorMessageFormat.PREFIX.getMessage();

    PaymentError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
