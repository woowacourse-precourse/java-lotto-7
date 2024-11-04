package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class LotteryBuyer {

    private final List<Lotto> lotteries;

    public LotteryBuyer(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
