package lotto.exception;

public enum PurchaseExceptionMessage implements ExceptionMessage {
    AMOUNT_LESS_THAN_PRICE("로또 가격보다 적은 금액입니다."),
    AMOUNT_NOT_MULTIPLE_OF_PRICE("로또 가격은 1000원 단위로만 가능합니다."),
    AMOUNT_EXCEEDS_LIMIT("로또는 한번에 10만원 까지 구입 가능합니다.");

    private final String message;

    PurchaseExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
