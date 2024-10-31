package lotto.domain;

import static lotto.domain.PurchaseAmount.*;

public class TicketCount {

    private final Integer count;

    public TicketCount(int inputAmount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
        this.count = calculateTicket(purchaseAmount);
    }

    public Integer getCount() {
        return count;
    }

    private int calculateTicket(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getAmount() / LOTTO_PRICE;
    }
}
