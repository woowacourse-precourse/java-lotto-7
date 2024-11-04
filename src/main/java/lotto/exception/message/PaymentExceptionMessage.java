package lotto.exception.message;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

public enum PaymentExceptionMessage {
    NOT_POSITIVE_NUMBER("0보다 더 큰 금액을 입력해주세요."),
    CANT_DIVIDE(String.format("%d원 단위로 금액을 입력해주세요.",LOTTO_PRICE));
    private final String message;

    PaymentExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}