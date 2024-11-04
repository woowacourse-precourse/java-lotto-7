package lotto.exception;

public enum MoneyExceptionType implements BaseExceptionType {
    ZERO_MONEY("[ERROR] 금액은 0원일 수 없습니다."),
    NEGATIVE_MONEY("[ERROR] 금액은 음수일 수 없습니다."),
    NOT_UNIT_MONEY("[ERROR] 금액은 1,000원 단위여야 합니다.");

    private final String errorMessage;

    MoneyExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String errorMessage() {
        return errorMessage;
    }
}