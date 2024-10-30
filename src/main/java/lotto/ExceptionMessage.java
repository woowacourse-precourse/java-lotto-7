package lotto;

public enum ExceptionMessage {
    PURCHASE_AMOUNT_NOT_NUMERIC_EXCEPTION("구입금액은 숫자로만 이루어져야 합니다.");

    private String exceptionMessagePrefix = "[ERROR] ";
    private String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessagePrefix + exceptionMessage;
    }

    public String message() {
        return exceptionMessage;
    }
}
