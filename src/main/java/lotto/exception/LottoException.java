package lotto.exception;

public enum LottoException {

    INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    EXCEED_MAXIMUM_PURCHASE_AMOUNT("[ERROR] 로또 구매 가능 금액은 최대 10만원입니다."),
    INVALID_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_PURCHASE_PRICE("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 보너스 번호는 이미 생성된 6개의 로또 번호와 중복될 수 없습니다."),
    UNDER_MINIMUM_PURCHASE_AMOUNT("[ERROR] 최소 구매 금액은 1000원 이상이어야 합니다."),
    UNDER_MINIMUM_PURCHASE_AGE("[ERROR] 최소 구매 가능 연령은 19세입니다."),
    EXCEED_MINIMUM_PURCHASE_AGE("[ERROR] 최대 구매 가능 연령은 120세입니다.");

    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
