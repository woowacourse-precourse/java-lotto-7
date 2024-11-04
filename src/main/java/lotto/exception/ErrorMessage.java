package lotto.exception;

public enum ErrorMessage {
    UNDER_ZERO_ERROR("0과 음수는 불가능 합니다."),
    UNDER_UNIT_ERROR("최소 구매 가능 금액은 1,000원 입니다."),
    UNITS_ERROR("구입금액은 1,000원 단위로 나누어 떨어져야 합니다."),
    RANGE_ERROR("입력된 값이 1~45 범위 밖의 수입니다."),
    NOT_INTEGER_ERROR("입력된 값이 정수가 아닙니다."),
    DUPLICATION_ERROR("로또 번호는 중복될 수 없습니다."),
    PARSING_ERROR("입력된 값이 숫자가 아닙니다."),
    SIZE_ERROR("로또 번호는 6개여야 합니다.");

    private static final String ERROR_PHRASE = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PHRASE + message;
    }
}

