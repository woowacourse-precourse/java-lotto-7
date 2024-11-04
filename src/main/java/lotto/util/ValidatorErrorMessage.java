package lotto.util;

public enum ValidatorErrorMessage {
    NUMERIC_EXCEPTION("정수를 입력하여야 합니다."),
    RANGE_EXCEPTION("1-45 사이의 숫자를 입력해야 합니다."),
    DUPLICATTE_EXCEPTION("중복되지 않는 숫자를 입력해야 합니다."),
    SEPARATER_EXCEPTION("당첨 번호는 쉼표로 구분되어야 합니다."),
    BONUS_DUPLICATTE_EXCEPTION("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BONUS_NUMERIC_EXCEPTION("보너스 번호를 정수여야 합니다."),
    NUMBER_COUNT_EXCEPTION("6개의 숫자를 입력해야 합니다."),
    MONEY_UNIT_EXCEPTION("1000원 단위로 입력해야 합니다.");

    private final static String prefix = "[ERROR] ";
    private final String errorMessage;

    ValidatorErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return prefix.concat(errorMessage);
    }
}
