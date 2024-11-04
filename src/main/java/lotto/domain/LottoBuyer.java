package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    // 구매 개수
    private int lottoPurchaseAmount;
    // 구매자의 총 수익률
    private int lotteryYield;
    // 구매자가 구입한 로또
    private List<Lotto> lottos;

    public LottoBuyer() {
        this.lottoPurchaseAmount = 0;
        this.lotteryYield = 0;
        this.lottos = new ArrayList<>();
    }

    public void setLottoPurchaseAmount(final int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public int calculateLotteryYield(final int purchaseAmount, final int totalWinningAmount) {
        this.lotteryYield = totalWinningAmount / purchaseAmount * 100;
        return lotteryYield;
    }

    public void addLotto(final Lotto lotto) {
        lottos.add(lotto);
    }
}
