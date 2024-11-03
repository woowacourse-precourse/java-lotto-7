package lotto.Util.Error;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER_COUNT("[ERROR] 로또의 당첨 번호는 6개 입니다."),
    INVALID_BONUS_NUMBER_COUNT("[ERROR] 로또의 보너스 번호는 1개 입니다."),
    INVALID_PURCHASE_UNIT("[ERROR] 로또 구입 금액은 1,000원 단위 정수로 입력해야 합니다."),
    PURCHASE_LIMIT_REACHED("[ERROR] 로또의 구매 한도에 도달했습니다."),
    MINIMUM_PURCHASE_AMOUNT("[ERROR] 로또의 최소 구입 금액은 1,000원 입니다.");

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
