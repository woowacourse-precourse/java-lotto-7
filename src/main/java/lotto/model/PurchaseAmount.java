package lotto.model;

import lotto.util.Parser;

public class PurchaseAmount {

    private static final int MINIMUM_AMOUNT = 0;
    private static final int LOTTO_UNIT_PRICE = 1000;
    private static final String ERROR_NEGATIVE_AMOUNT = "[ERROR] 구매 금액은 " + MINIMUM_AMOUNT + " 이상이어야 합니다.";
    private static final String ERROR_INVALID_UNIT = "[ERROR] 로또 구입 금액은 " + LOTTO_UNIT_PRICE + "원 단위여야 합니다.";

    private final Integer purchaseAmount;

    public PurchaseAmount(String purchaseAmountInput) {
        Integer purchaseAmount = Parser.parseStringToInt(purchaseAmountInput);
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(Integer purchaseAmount) {
        if (purchaseAmount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_AMOUNT);
        }
        if (purchaseAmount % LOTTO_UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_UNIT);
        }
    }

    public int getLottoQuantity() {
        return purchaseAmount / LOTTO_UNIT_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
