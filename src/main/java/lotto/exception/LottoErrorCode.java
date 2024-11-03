package lotto.exception;

public enum LottoErrorCode {

    LOTTO_PRICE_NOT_IN_1_000("[ERROR] 로또 가격은 1,000원 단위여야 합니다."),
    LOTTO_PRICE_NOT_BLANK("[ERROR] 구입 금액을 입력해 주세요."),
    LOTTO_PRICE_NOT_POSITIVE_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    LOTTO_PRICE_NOT_UNDER_1_000("[ERROR] 구입 금액은 1,000원 이상이어야 합니다."),
    LOTTO_PRICE_NOT_OVER_1_000_000("[ERROR] 구입 금액은 1,000,000원 이하이어야 합니다."),

    ;

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
