package lotto;

public class Validator {
    void validatePurchaseAmount(String purchaseAmount) {
        if (!purchaseAmount.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("구매 금액이 양수가 아닙니다.");
        }
    }
}
