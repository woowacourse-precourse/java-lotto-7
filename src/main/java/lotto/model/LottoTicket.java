package lotto.model;

import java.util.List;

public class LottoTicket {

    private final List<Lotto> lotteries;
    private final int purchase;
    private final int quantity;

    public LottoTicket(List<Lotto> lotteries, int purchase, int quantity) {
        this.lotteries = lotteries;
        this.purchase = purchase;
        this.quantity = quantity;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getPurchase() {
        return purchase;
    }

    public int getQuantity() {
        return quantity;
    }
}
