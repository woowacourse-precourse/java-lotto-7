package lotto.model.domain;

import java.util.List;

public class LottoPrizes {
    private List<LottoPrize> prizes;

    public LottoPrizes(List<LottoPrize> prizes) {
        this.prizes = prizes;
    }

    public List<LottoPrize> get() {
        return prizes;
    }

    public ProfitRatio getProfitRatio(int purchaseAmount) {
        int totalAmount = prizes.stream()
                .mapToInt(LottoPrize::getPrize)
                .sum();
        return new ProfitRatio(totalAmount, purchaseAmount);
    }


}
