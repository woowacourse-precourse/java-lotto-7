package lotto.model;

import java.util.List;

public class LottoTicket {

    private final List<Lotto> lotteries;
    private final int purchase;

    public LottoTicket(List<Lotto> lotteries, int purchase) {
        this.lotteries =lotteries;
        this.purchase = purchase;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getPurchase() {
        return purchase;
    }
}
