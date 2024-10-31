package lotto.enums;

public enum ErrorMessage {
    INVALID_AMOUNT("[ERROR] 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨 번호는 6개여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
