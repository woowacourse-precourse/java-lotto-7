package lotto.error;

public enum LottoError {
    INVALID_PRICE_AMOUNT("[ERROR] 구입 금액은 1000 단위여야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 구매 금액은 숫자여야 합니다."),
    INVALID_PRICE("[ERROR] 금액은 1000 이상이어야 합니다.");

    private final String message;

    LottoError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
