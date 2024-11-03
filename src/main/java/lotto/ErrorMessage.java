package lotto;

public enum ErrorMessage {

    INPUT_BLANK("필수 입력입니다"),

    INPUT_MUST_NUMERIC("숫자를 입력해야 합니다"),
    INSERT_MONEY_NOT_DIVIDED_1000("구입 금액은 1000원 단위로 떨어져야 합니다"),
    MONEY_CAN_NOT_MINUS("구입 금액이 음수일 수는 없습니다"),
    WIN_NUMBER_SIZE_MUST_6("당첨 번호는 6개를 입력하여야 합니다"),
    LOTTO_NUMBER_BETWEEN_1_AND_45("로또 번호는 1부터 45 사이의 숫자여야 합니다"),
    DUPLICATE_WIN_NUMBERS("중복된 당첨 번호를 입력하였습니다"),
    BONUS_NUMBER_DUPLICATE_WIN_NUMBERS("보너스 번호가 당첨 번호와 중복됩니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
