package content;

public enum ErrorMessage {
    WINNING_NUMBERS_OVERLAP("[ERROR] 당첨 번호는 6개이어야 합니다."),
    INPUT_BUY_AMOUNT_WRONG("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    AGAIN_INPUT_BUY_AMOUNT("[ERROR] 유효한 금액을 입력해 주세요."),
    LOTTO_NUMBERS_MIN_MAX("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATION("[ERROR] 로또 번호는 중복되지 않는 6개 숫자여야 합니다."),
    BONUS_NUMBERS_MIN_MAX("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    EMPTY_WINNING_NUMBERS("[ERROR] 당첨 번호를 입력해야 합니다."),
    WINNING_NUMBERS_DUPLICATION("[ERROR] 당첨 번호에 중복된 숫자가 있습니다: "),
    BONUS_AND_WINNING_NUMBERS_DUPLICATION("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}