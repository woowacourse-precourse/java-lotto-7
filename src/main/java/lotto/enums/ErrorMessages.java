package lotto.enums;

public enum ErrorMessages {
    INVALID_PURCHASE_AMOUNT_FORMAT("[ERROR] 로또 구입 금액은 숫자 형식이어야 합니다."),
    INVALID_PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다."),
    INVALID_PURCHASE_AMOUNT_BELOW_MINIMUM("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다."),

    INVALID_WINNING_NUMBER_FORMAT("[ERROR] 로또 당첨 번호는 숫자 형식이어야 합니다."),
    INVALID_WINNING_NUMBER_SIZE("[ERROR] 로또 당첨 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER_DELIMITER("[ERROR] 로또 당첨 번호는 쉼표(,)로 구분되어야 합니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 로또 당첨 번호는 1에서 45 사이의 숫자여야 합니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 로또 당첨 번호에 중복된 숫자가 포함되어 있습니다."),

    INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 번호는 숫자 형식이어야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호가 로또 당첨 번호와 중복됩니다.");



    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
