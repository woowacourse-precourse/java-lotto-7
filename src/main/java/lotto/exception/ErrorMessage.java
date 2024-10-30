package lotto.exception;

public enum ErrorMessage {
    ERROR_EMPTY_VALUE("[ERROR] 입력 값이 없습니다."),
    ERROR_INVALID_NUMBER("[ERROR] 입력 값이 숫자가 아닙니다."),
    ERROR_NEGATIVE_NUMBER("[ERROR] 입력 값은 음수가 될 수 없습니다."),
    ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE("[ERROR] 금액이 부족하거나 1000원 단위로 구매 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
