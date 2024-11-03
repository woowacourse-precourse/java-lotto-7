package lotto.model;

import java.util.Map;

public class LottoResult {
    private final Map<LottoPrizeType, Integer> lottoPrizes;
    private final double totalBenefit;

    public LottoResult(Map<LottoPrizeType, Integer> lottoPrizes, double totalBenefit) {
        this.lottoPrizes = lottoPrizes;
        this.totalBenefit = totalBenefit;
    }

    public Map<LottoPrizeType, Integer> getLottoPrizes() {
        return lottoPrizes;
    }

    public double getTotalBenefit() {
        return totalBenefit;
    }
}
