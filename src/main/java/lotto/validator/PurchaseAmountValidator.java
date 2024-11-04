package lotto.validator;

public class PurchaseAmountValidator implements Validator<Integer> {

    @Override
    public void validate(Integer purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0보다 커야 합니다.");
        }
    }
}
