package lotto.exception;

public enum LottoExceptionStatus {

    INVALID_LOTTO_PURCHASE_AMOUNT("구입 금액이 올바르지 않습니다. 로또 하나당 금액은 1000원입니다."),
    INVALID_LOTTO_PURCHASE_NUMBER_FORMAT("구입금액은 정수만 입력 가능합니다."),
    INVALID_WINNING_NUMBER_RANGE("당첨 로또 번호가 올바르지 않습니다. 번호는 1 ~ 45 사이 숫자만 가능합니다."),
    INVALID_WINNING_NUMBER_FORMAT("당첨 로또 번호에는 정수만 입력 가능합니다."),
    INVALID_WINNING_NUMBER_DUPLICATE("중복된 당첨 로또 번호가 존재합니다."),
    INVALID_WINNING_NUMBER_SIZE("당첨 로또 번호는 6개여야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호가 올바르지 않습니다. 번호는 1 ~ 45 사이 숫자만 가능합니다."),
    INVALID_BONUS_NUMBER_DUPLICATE_WITH_WINNING("보너스 번호가 당첨 로또 번호와 중복됩니다."),
    INVALID_BONUS_NUMBER_FORMAT("보너스 번호에는 정수만 입력 가능합니다"),
    INVALID_GENERATED_LOTTO_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_GENERATED_LOTTO_NUMBERS_RANGE("로또 번호는 1 ~ 45 사이 숫자만 가능합니다."),
    INVALID_GENERATED_LOTTO_NUMBERS_DUPLICATE("중복된 로또 번호가 존재합니다.");

    private final String message;

    LottoExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
