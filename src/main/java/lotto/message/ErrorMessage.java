package lotto.message;

public enum ErrorMessage {

    PAYMENT_EMPTY("[ERROR] 공백은 허용되지 않습니다."),
    PAYMENT_NOT_A_NUMBER("[ERROR] 숫자를 입력해야 합니다."),
    PAYMENT_INVALID_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    PAYMENT_LIMIT_EXCEEDED("[ERROR] 구입 금액은 최대 100,000원으로 제한됩니다."),

    WINNING_NUMBER_INVALID_INPUT("[ERROR] 당첨 번호의 입력이 올바르지 않습니다."),
    WINNING_NUMBER_COUNT_INVALID("[ERROR] 당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_DUPLICATE("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_OUT_OF_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),

    BONUS_NUMBER_INVALID_INPUT("[ERROR] 보너스 번호의 입력이 올바르지 않습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

