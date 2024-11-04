package lotto.constant;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR]"),
    IS_NOT_NUMBER(ERROR_PREFIX.getValue() + "숫자가 아닌 값을 입력하였습니다."),
    IS_NOT_DIVISIBLE_BY_THOUSAND(ERROR_PREFIX.getValue() + "1000원 단위의 숫자를 입력해야 합니다."),
    IS_NOT_VALID_NUMBER_SIZE(ERROR_PREFIX.getValue() + "당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_CONFLICT(ERROR_PREFIX.getValue() + "당첨 번호는 중복될 수 없습니다"),
    BONUS_NUMBER_CONFLICT(ERROR_PREFIX.getValue() + "당첨 번호와 보너스 번호는 같을 수 없습니다"),
    INCLUDE_INVALID_DELIMITER(ERROR_PREFIX.getValue() + "허용되지 않는 구분자가 포함되어있습니다"),
    IS_NOT_SINGLE_DIGIT(ERROR_PREFIX.getValue() + "한 자리의 숫자만 입력할 수 있습니다.");


    private final String value;

    private ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
