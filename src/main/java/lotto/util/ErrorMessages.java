package lotto.util;

public enum ErrorMessages {
    INVALID_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_INPUT("[ERROR] 올바른 숫자를 입력해 주세요."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_WINNING_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}