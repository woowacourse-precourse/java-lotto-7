package lotto.exception;

public enum MoneyException implements CustomException {

    INVALID_AMOUNT("금액은 0 이상이어야 합니다.");

    private final String message;

    MoneyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
