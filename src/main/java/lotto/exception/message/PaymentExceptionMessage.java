package lotto.exception.message;

public enum PaymentExceptionMessage {
    NOT_POSITIVE_NUMBER("0보다 더 큰 금액을 입력해주세요!"),
    CANT_DIVIDE("1000원 단위로 금액을 입력해주세요!");
    private final String message;

    PaymentExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}