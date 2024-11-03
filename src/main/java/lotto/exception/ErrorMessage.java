package lotto.exception;

public enum ErrorMessage {

    NUMBER_NOT_DIVIDE_THOUSAND("숫자는 1,000 단위로 나누어 떨어져야 합니다"),
    INVALID_LOTTO_LENGTH("로또 번호는 6개여야 합니다."),
    INVALID_DATA_TYPE("데이터 타입이 잘못되었습니다."),
    DUPLICATED_LOTTO_NUMBER("중복된 숫자를 포함할 수 없습니다"),
    ;


    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX + message;
    }

    public String get() {
        return message;
    }
}
