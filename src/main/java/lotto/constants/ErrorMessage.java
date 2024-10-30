package lotto.constants;

public enum ErrorMessage {

    HAS_TOO_MANY_NUMBERS("로또 번호는 6개여야 합니다."),
    HAS_DUPLICATED_NUMBER("로또 번호는 중복될 수 없습니다."),
    HAS_OUT_OF_RANGE_NUMBER("로또 번호는 1 ~ 45 사이 숫자만 가능합니다."),
    IS_INVALID_PRICE("유효하지 않은 금액입니다.");

    private static final String ERROR_PREFIX = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + " " + message;
    }
}
