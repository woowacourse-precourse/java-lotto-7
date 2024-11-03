package lotto.exception;

public enum MoneyExceptionType {
    EMPTY_INPUT_MONEY("[ERROR] 구입 금액을 입력해주세요. 구입 금액은 최소 1,000원에서 최대 100,000원입니다."),
    OUT_OF_RANGE_MONEY("[ERROR] 구입 금액은 최소 1,000원에서 최대 100,000원입니다."),
    NOT_INTEGER_MONEY("[ERROR] 1000으로 나누어떨어지는 정수만 입력해주세요.");

    private final String message;

    MoneyExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
