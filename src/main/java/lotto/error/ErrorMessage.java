package lotto.error;

public enum ErrorMessage {
    INVALID_COST("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다"),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
