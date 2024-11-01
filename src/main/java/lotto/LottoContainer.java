package lotto;

import java.util.List;

public class LottoContainer {
    private final List<Lotto> lotteries;

    public LottoContainer(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public int getSize() {
        return lotteries.size();
    }
}
