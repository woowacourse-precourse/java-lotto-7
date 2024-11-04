package lotto.exception;

public enum ErrorMessage {

    INVALID_PURCHASE_MONEY("구입금액은 1000원 이상이면서 1000원 단위여야 합니다."),
    INVALID_INPUT_NUMBER("숫자만 입력해 주세요."),
    INVALID_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBERS_FORMAT("당첨 번호는 쉼표(,)로 구분된 숫자여야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
