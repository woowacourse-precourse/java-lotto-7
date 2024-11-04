package lotto.exception;

public enum MoneyErrorCode {
    MONEY_MAX_ERROR("돈의 최대 값은 2147483647 이하여야 합니다."),
    MONEY_MIN_ERROR("돈은 0보다 커야 합니다"),
    MONEY_PARSE_ERROR("돈은 숫자여야 합니다"),
    MONEY_DIVIDE_ERROR("거스름돈은 존재할 수 없습니다"),
    ;

    private final String message;

    MoneyErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
