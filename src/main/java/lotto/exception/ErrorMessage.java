package lotto.exception;

public enum ErrorMessage {
    ERROR_MESSAGE_PREFIX("[ERROR] "),
    CONTAIN_BLANK("공백을 포함한 문자열은 입력할 수 없습니다."),
    IS_EMPTY("빈 문자열은 입력할 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("구입금액은 1000, 2000, ..., 100000 중 하나의 값이어야 합니다."),
    INVALID_WINNING_NUMBERS("당첨 번호들이 포함된 문자열은 2자리 이하의 숫자 6개를 ,로 연결한 형태여야 합니다."),
    DUPLICATED_WINNING_NUMBERS("당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_OUT_OF_RANGE("당첨 번호는 1 이상, 45 이하의 정수 값이어야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 1 이상, 45 이하의 정수 값이어야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("당첨 번호는 1 이상, 45 이하의 정수 값이어야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE_PREFIX.message + message;
    }
}
