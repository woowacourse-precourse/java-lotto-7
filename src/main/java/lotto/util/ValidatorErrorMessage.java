package lotto.util;

public enum ValidatorErrorMessage {
    NUMERIC_EXCEPTION("정수를 입력하여야 합니다."),
    RANGE_EXCEPTION("1-45 사이의 숫자를 입력해야 합니다."),
    DUPLICATTE_EXCEPTION("중복되지 않는 숫자를 입력해야 합니다."),
    NUMBER_COUNT_EXCEPTION("6개의 숫자를 입력해야 합니다."),
    MONEY_UNIT_EXCEPTION("1000원 단위로 입력해야 합니다.");

    private final String errorMessage;
    private final static String prefix = "[ERROR]";

    ValidatorErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return prefix.concat(errorMessage);
    }
}
