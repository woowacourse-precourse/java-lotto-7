package common;

public enum ErrorMessage {
    NUMBER_OUT_OF_RANGE("숫자가 입력 가능한 범위를 넘어섰습니다."),
    DIVISIBILITY_BY_THOUSAND_ERROR("구매 금액 입력값이 1000으로 나누어 떨어지지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
