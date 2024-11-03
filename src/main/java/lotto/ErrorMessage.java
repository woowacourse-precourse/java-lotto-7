package lotto;

public enum ErrorMessage {
    INVALID_NUMBER("[ERROR] 유효한 숫자를 입력하세요."),
    DIVISIBLE_BY_THOUSAND("[ERROR] 1,000원으로 나누어 떨어지게 입력하세요."),
    BONUS_OUT_OF_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_DUPLICATE_WITH_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 중복되지 않는 숫자를 입력하세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}