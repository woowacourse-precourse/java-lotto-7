package lotto.common.exception;

public enum ExceptionMessages {
    EMPTY_INPUT("입력값이 없습니다. 다시 입력해주세요."),
    NONE_NUMERIC_INPUT("구입 금액은 숫자여야 합니다."),
    OUT_OF_INTEGER_RANGE("구입 금액은 정수 범위여야 합니다."),
    NOT_MULTIPLE_OF_UNIT_PRICE("구입 금액은 개당 금액의 배수여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String messages;

    ExceptionMessages(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        return ERROR_PREFIX + messages;
    }
}
