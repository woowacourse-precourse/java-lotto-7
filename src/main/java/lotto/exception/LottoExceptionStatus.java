package lotto.exception;

public enum LottoExceptionStatus {


    INVALID_LOTTO_PURCHASE_AMOUNT("[ERROR] 구입 금액이 올바르지 않습니다. 로또 하나당 금액은 1000원입니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 로또 번호가 올바르지 않습니다. 번호는 1 ~ 45 사이 숫자만 가능합니다."),
    INVALID_WINNING_NUMBER_DUPLICATE("[ERROR] 중복된 당첨 로또 번호가 존재합니다."),
    INVALID_WINNING_NUMBER_SIZE("[ERROR] 당첨 로또 번호는 6개여야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호가 올바르지 않습니다. 번호는 1 ~ 45 사이 숫자만 가능합니다."),
    INVALID_GENERATED_LOTTO_NUMBERS_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_GENERATED_LOTTO_NUMBERS_RANGE("[ERROR] 로또 번호는 1 ~ 45 사이 숫자만 가능합니다."),
    INVALID_GENERATED_LOTTO_NUMBERS_DUPLICATE("[ERROR] 중복된 로또 번호가 존재합니다.");

    private final String message;

    LottoExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
