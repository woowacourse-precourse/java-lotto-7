package lotto.exception;

public enum ErrorMessage {

    ERROR_SIGNATURE("[ERROR] "),
    INVALID_INPUT("빈 값을 입력할 수 없습니다. 다시 입력해 주세요."),
    ONLY_NUMERIC("숫자만 입력할 수 있습니다."),
    CONTAIN_BLANK("공백을 입력할 수 없습니다. 공백을 제외하고 다시 입력해 주세요."),
    NOT_DIVIDE_PURCHASE_AMOUNT("구입 금액은 1000원 단위로 입력해야 합니다."),
    EXCEED_PURCHASE_AMOUNT("구입 금액은 10만원을 초과할 수 없습니다."),
    LOTTO_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("당첨 번호는 1 부터 45 까지의 정수만 입력할 수 있습니다."),
    WINNING_NUMBERS_DELIMITER("당첨 번호는 공백없이 쉼표로 구분된 정수들로 입력해야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1 부터 45 까지 한자리의 정수만 입력할 수 있습니다."),
    BONUS_NUMBER_DUPLICATE_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_SIGNATURE.message + this.message;
    }
}
