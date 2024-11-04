package lotto.utils;

public enum ErrorMessages {
    BLANK_INPUT("입력이 공백일 수 없습니다."),
    NON_NUMERIC("금액은 숫자여야 합니다."),
    NOT_MULTIPLE_OF_THOUSAND("금액은 1,000원으로 나누어 떨어져야 합니다."),
    NOT_ZERO("금액은 0일 수 없습니다."),
    NEGATIVE_AMOUNT("금액은 0보다 커야 합니다."),
    DUPLICATE_NUMBERS("중복된 숫자가 포함되어 있습니다."),
    OUT_OF_RANGE("숫자는 1에서 45 사이여야 합니다."),
    NON_NUMERIC_INPUT("입력된 값 중 숫자가 아닌 값이 있습니다."),
    NOT_SIX_NUMBERS("당첨 번호는 6개여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 숫자여야 합니다."),
    BONUS_OUT_OF_RANGE("보너스 번호는 1에서 45 사이여야 합니다."),
    BONUS_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}