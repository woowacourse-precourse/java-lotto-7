package lotto.dto;

import lotto.util.NumberParser;

public class PurchaseAmountRequest {
    private final int amount;

    private PurchaseAmountRequest(int amount) {
        this.amount = amount;
    }

    public static PurchaseAmountRequest from(String purchaseAmount) {
        int parsedAmount = NumberParser.parseIntegerFromString(purchaseAmount);
        return new PurchaseAmountRequest(parsedAmount);
    }

    public int getAmount() {
        return amount;
    }
}
