package lotto.error;

public enum ErrorMessage {
    INVALID_COST("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다"),
    INVALID_WINNING_NUMBERS_COUNT("[ERROR] 당첨 번호는 6개를 입력해야 합니다"),
    DUPLICATED_NUMBER("[ERROR] 당첨 번호는 중복되지 않아야 합니다"),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자가 아닌 값을 입력했습니다."),
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
