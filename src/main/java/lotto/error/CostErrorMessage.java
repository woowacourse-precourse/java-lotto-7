package lotto.error;

public enum CostErrorMessage implements ErrorMessage {
    IS_NOT_NUMBER("숫자만 입력할 수 있습니다."),
    CAN_NOT_DIVIDED("1000원으로 나누어 떨어지지 않습니다."),
    INSUFFICIENT_MONEY("최소 구입 비용은 1000원입니다."),
    TOO_MANY_MONEY("최대 구입 비용은 100만원입니다.");

    private final String message;

    CostErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
