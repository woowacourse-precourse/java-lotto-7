package lotto.error;

public enum ErrorMessage {
    INVALID_COST("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다"),
    INVALID_WINNING_NUMBERS_COUNT("[ERROR] 당첨 번호는 6개를 입력해야 합니다"),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
