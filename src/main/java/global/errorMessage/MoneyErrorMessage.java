package global.errorMessage;

public enum MoneyErrorMessage {
    INVALID_MONEY_FORMAT("1000원 단위로만 입력해야 합니다"),
    OUT_OF_RANGE("0원 이상 결제해야 합니다.");


    private final String message;

    MoneyErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
