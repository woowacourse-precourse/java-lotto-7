package lotto.global;

public enum ErrorMessage {
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    DUPLICATED_NUMBERS_IN_LOTTO("로또 번호에 중복된 숫자가 있습니다."),

    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
