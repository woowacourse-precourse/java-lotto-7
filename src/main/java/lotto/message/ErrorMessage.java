package lotto.message;

public enum ErrorMessage {
    PAYMENT_IS_BLANK("[ERROR] 공백은 허용되지 않습니다."),
    INVALID_PAYMENT_FORMAT("[ERROR] 숫자를 입력해야 합니다."),
    INVALID_PAYMENT_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_PAYMENT_LIMIT("[ERROR] 구입 금액은 최대 100,000원으로 제한됩니다."),

    INVALID_WINNING_NUMBER_INPUT("[ERROR] 당첨 번호의 입력이 올바르지 않습니다."),
    INVALID_WINNING_NUMBER_SIZE("[ERROR] 당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_DUPLICATES("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),

    INVALID_BONUS_NUMBER_INPUT("[ERROR] 보너스 번호의 입력이 올바르지 않습니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
