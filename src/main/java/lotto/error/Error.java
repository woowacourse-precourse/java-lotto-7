package lotto.error;

public enum Error {
    ERROR_PREFIX("[ERROR]"),
    ERROR_DELIMITER(" "),
    EMPTY_INPUT_ERROR("입력은 필수적으로 하셔야 합니다."),
    EMPTY_STRING_ERROR("빈 문자열은 입력하실 수 없습니다."),
    WRONG_NUMBER_FORMAT_ERROR("정수가 아닌 값은 입력하실 수 없습니다."),
    NON_POSITIVE_AMOUNT_ERROR("금액에 0과 음의 정수는 입력하실 수 없습니다."),
    NOT_GREATER_THAN_MINNIMUM_AMOUNT_UNIT_ERROR("최소 금액 단위보다 작은 단위의 금액은 입력하실 수 없습니다."),
    CANNOT_PURCHASE_ANY_PRODUCT("상품의 가격보다 낮은 금액은 입력하실 수 없습니다."),
    GREATER_THAN_MAXIMUM_AMOUNT_ERROR("최대 입력 가능 금액인 %d보다 큰 금액을 입력하실 수 없습니다."),
    WRONG_LOTTO_NUMBER_COUNT("로또 번호는 %d개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복되지 않는 수로 구성되어야 합니다."),
    WRONG_LOTTO_NUMBER_RANGE("로또 번호는 %d~%d의 수로 구성되어야 합니다."),
    ;


    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + ERROR_DELIMITER.message + message;
    }

    public String format(Object... args) {
        return String.format(getMessage(), args);
    }
}
