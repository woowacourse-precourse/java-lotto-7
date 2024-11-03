package lotto.model;

import lotto.util.Parser;

public class PurchaseAmount {

    private final Integer purchaseAmount;

    public PurchaseAmount(String purchaseAmountInput) {
        Integer purchaseAmount = Parser.parseStringToInt(purchaseAmountInput);
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(Integer purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0 이상이어야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public int getLottoQuantity() {
        return purchaseAmount / 1000;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
