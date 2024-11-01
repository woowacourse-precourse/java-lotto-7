package lotto.exception.lotto;

public enum LottoErrorMessages {
    INVALID_AMOUNT_NON_POSITIVE("[ERROR] 로또 구입 금액은 양수만 입력 가능합니다."),
    INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");

    private final String message;

    LottoErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
