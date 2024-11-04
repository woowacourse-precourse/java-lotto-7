package lotto.validator;

public enum ValidationMessage {
    PREFIX("[ERROR] "),
    INVALID_PURCHASE_PRICE_FORMAT("로또 구입금액은 숫자로 입력되어야 합니다."),
    INVALID_NEGATIVE_PRICE("로또 구입금액은 양의 정수가 입력되어야 합니다."),
    INVALID_PURCHASE_PRICE("로또 구입금액은 1,000원으로 나누어 떨어져야 합니다."),
    INVALID_NUMBER_COUNTS("로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBERS("로또는 중복되지 않는 숫자 6개로 구성되어야 합니다."),
    INVALID_WINNING_NUMBERS_FORMAT("당첨 번호는 쉼표(,)를 기준으로 구분하여 6개의 숫자가 입력되어야 합니다."),
    INVALID_NUMBER_RANGE("로또 번호의 숫자 범위는 1~45까지 입니다."),
    INVALID_BONUS_NUMBER_FORMAT("보너스 번호는 1개의 숫자가 입력되어야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
