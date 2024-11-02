package lotto.exception;

public enum ErrorBase {
    BLANK_PURCHASE_AMOUNT("[ERROR] 구입 금액을 입력해주세요."),
    NON_NUMERIC_PURCHASE_AMOUNT("[ERROR] 구입 금액은 숫자여야 합니다."),

    BLANK_WINNING_NUMBERS("[ERROR] 당첨 번호를 입력해주세요."),
    NON_NUMERIC_WINNING_NUMBERS("[ERROR] 당첨 번호는 숫자여야 합니다."),

    BLANK_BONUS_NUMBER("[ERROR] 보너스 번호를 입력해주세요."),
    NON_NUMERIC_BONUS_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다.");

    private final String message;

    ErrorBase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
