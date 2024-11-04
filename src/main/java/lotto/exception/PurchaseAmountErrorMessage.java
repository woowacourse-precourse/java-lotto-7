package lotto.exception;

public enum PurchaseAmountErrorMessage {

    IS_NOT_POSSIBLE_RANGE("[ERROR] 구매 가능한 범위가 아닌 가격이 입력되었습니다."),
    IS_NOT_DIVISIBLE("[ERROR] 지불한 금액이 1,000원으로 나누어 떨어지지 않습니다.");

    private final String message;

    PurchaseAmountErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
