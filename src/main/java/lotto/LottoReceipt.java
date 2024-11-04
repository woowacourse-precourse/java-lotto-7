package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoReceipt {

    private int quantity;
    private List<Lotto> lotteries;


    public LottoReceipt(List<Lotto> lotteries) {
        this.lotteries = new ArrayList<>(lotteries);
        quantity = this.lotteries.size();
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
