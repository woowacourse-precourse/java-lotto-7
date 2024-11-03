package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.util.LottoValidator.parseNumber;

public class TicketCount {

    private final PurchaseAmount amount;
    private final Integer count;

    public TicketCount(String purchaseAmount) {
        int parseNumber = parseNumber(purchaseAmount);
        this.amount = new PurchaseAmount(parseNumber);
        this.count = calculateTicket(amount);
    }

    public Integer getCount() {
        return count;
    }

    public Integer getAmount() {
        return amount.amount();
    }

    private int calculateTicket(PurchaseAmount purchaseAmount) {
        return purchaseAmount.amount() / LOTTO_PRICE.getValue();
    }
}
