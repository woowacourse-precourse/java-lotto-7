package lotto.exception;

public enum LottoExceptionStatus {


    INVALID_LOTTO_PURCHASE_AMOUNT("구입 금액이 올바르지 않습니다. 로또 하나당 금액은 1000원입니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호가 올바르지 않습니다. 번호는 1 ~ 45 사이 숫자만 가능합니다.");


    private final String message;

    LottoExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
