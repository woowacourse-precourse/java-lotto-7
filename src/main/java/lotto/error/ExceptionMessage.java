package lotto.error;

public enum ExceptionMessage {
    ERROR_MESSAGE_INPUT_IS_EMPTY("빈 문자열을 입력하면 안됩니다."),
    ERROR_MESSAGE_IS_NOT_NUMBER("올바른 정수 형식이 아닙니다."),
    ERROR_MESSAGE_IS_NOT_POSITIVE_NUMBER("값은 양수이어야 합니다."),
    ERROR_MESSAGE_IS_NOT_VALID_COST("구입 금액은 로또 가격에 나누어 떨어져야 합니다."),
    ERROR_MESSAGE_IS_NOT_IN_LOTTO_NUMBER_RANGE("로또 번호는 1~45 사이의 수이어야 합니다. "),
    ERROR_MESSAGE_DUPLICATED_LOTTO_NUMBER("로또 하나에 중복된 번호가 있으면 안됩니다."),
    ERROR_MESSAGE_IS_NOT_VALID_LOTTO_NUMBERS("로또 번호 개수는 6개여야 합니다."),
    ERROR_MESSAGE_IS_NOT_VALID_CORRECT_COUNT("로또 번호 당첨 개수가 유효하지 않습니다."),
    ;

    private final String ERROR_MESSAGE_HEAD = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_MESSAGE_HEAD + message;
    }

}
