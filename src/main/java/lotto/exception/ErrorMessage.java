package lotto.exception;

public enum ErrorMessage {
    INVALID_COST_FORMAT("금액은 양수이어야 합니다."),
    INVALID_COST_RANGE("금액은 1000원 이상, 100000 이하만 가능합니다."),
    INVALID_COST_UNIT("금액은 1000의 배수만 가능합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
