package lotto.validator;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    TYPE("정수 형태의 숫자가 아닙니다."),
    RANGE("1~45 범위의 번호가 아닙니다."),
    DIVIDE("1,000으로 나누어 떨어지지 않습니다."),
    BONUS_NUMBER_DUPLICATION("보너스 번호가 당첨 번호와 중복됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
