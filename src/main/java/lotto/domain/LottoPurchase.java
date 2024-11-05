package lotto.domain;

import lotto.utils.PurchaseValidator;

public class LottoPurchase {
    private final int amount;
    private final int ticketCount;

    private LottoPurchase(int amount) {
        PurchaseValidator.validateAmount(String.valueOf(amount));
        this.amount = amount;
        this.ticketCount = amount / 1000;
    }

    public static LottoPurchase of(int amount) {
        return new LottoPurchase(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
