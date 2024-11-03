package lotto.exception;

public enum ErrorCode {
    INVALID_PURCHASE_AMOUNT("[ERROR] 로또 구매금액은 1000원 단위여야 합니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_WINNING_NUMBER_FORMAT("[ERROR] 올바른 형식의 당첨 번호를 입력해주세요."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_COMMA_FORMAT("[ERROR] 올바른 쉼표(,) 형식으로 입력해 주세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public IllegalArgumentException throwError() {
        return new IllegalArgumentException(this.getMessage());
    }

    public IllegalArgumentException throwError(String additionalMessage) {
        return new IllegalArgumentException(this.getMessage() + " " + additionalMessage);
    }
}