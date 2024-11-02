package lotto.exception;

public enum ErrorMessage {
    INPUT_IS_NULL("null을 입력했습니다."),
    INPUT_IS_EMPTY("빈 값을 입력했습니다."),

    MONEY_HAS_CHARACTER("금액은 숫자여야 합니다."),
    MONEY_IS_NEGATIVE_NUMBER("음수인 금액을 입력할 수 없습니다."),
    MONEY_IS_LESS_THAN_UNIT_PRICE("최소 금액보다 낮은 금액을 입력했습니다."),
    MONEY_IS_NOT_DIVIDED_BY_UNIT_PRICE("기준 금액으로 나눠지지 않는 금액입니다."),

    LOTTO_SIZE_IS_NOT_VALID("당첨 번호는 6개여야 합니다."),
    LOTTO_NUMBER_HAS_CHARACTER("당첨 번호는 숫자여야 합니다."),
    LOTTO_NUMBER_HAS_DUPLICATED_NUMBER("당첨 번호에 중복된 숫자가 존재합니다."),
    LOTTO_NUMBER_HAS_OUT_OF_BOUND_NUMBER("당첨 번호 중 범위를 벗어난 숫자가 존재합니다."),

    BONUS_NUMBER_HAS_CHARACTER("보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_HAS_OUT_OF_BOUND_NUMBER("보너스 번호 중 범위를 벗어난 숫자가 존재합니다."),
    BONUS_NUMBER_IS_IN_LOTTO_NUMBER("보너스 번호가 당첨 번호에 이미 존재합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String READ_AGAIN_MESSAGE = " 다시 입력해주세요.";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + errorMessage + READ_AGAIN_MESSAGE;
    }
}
