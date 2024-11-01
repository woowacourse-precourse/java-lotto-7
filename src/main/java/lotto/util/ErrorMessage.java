package lotto.util;

public enum ErrorMessage {

    PURCHASE_AMOUNT_NOT_DIVISION_ERROR("[ERROR] " + "입력하신 금액이 나누어떨어지지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
