package lotto.util;

public enum ErrorMessage {

    PURCHASE_AMOUNT_NOT_DIVISION_ERROR("[ERROR] " + "입력하신 금액이 나누어떨어지지 않습니다. "),
    WINNING_NUMBERS_SIZE_ERROR("[ERROR] " + "당첨번호는 6개여야합니다. "),
    WINNING_NUMBERS_DUPLICATE_ERROR("[ERROR] " + "당첨번호는 중복되지 않아야합니다. "),
    ;


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
