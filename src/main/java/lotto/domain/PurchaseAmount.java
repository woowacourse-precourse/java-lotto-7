package lotto.domain;

import static lotto.constant.GlobalConstant.TICKET_PRICE;
import static lotto.util.UserUtil.parseAndValidatePurchaseAmount;

public class PurchaseAmount {
    private final int amount;
    private final int ticketQuantity;

    public PurchaseAmount(String amount) {
        this.amount = parseAndValidatePurchaseAmount(amount);
        this.ticketQuantity = this.amount / TICKET_PRICE;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public int getAmount() {
        return amount;
    }
}
