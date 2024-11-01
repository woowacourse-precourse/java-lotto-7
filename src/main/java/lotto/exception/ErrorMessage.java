package lotto.exception;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    EMPTY_INPUT("값이 입력되지 않았습니다."),
    NOT_NUMBER("숫자가 아닌 값이 포함되었습니다."),
    NOT_MULTIPLE_THOUSAND("1000의 배수가 아닙니다."),
    WHITESPACE("공백이 포함되었습니다."),
    DUPLICATE_VALUES("중복된 값이 입력되었습니다."),
    NOT_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    NOT_NUMBER_RANGE("번호는 1 ~ 45 사이의 값이어야 합니다."),
    NOT_INTEGER_NUMBER("정수만 입력 가능합니다."),
    NOT_BONUS_SIZE("보너스 번호는 1개만 입력되어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + message;
    }
}
