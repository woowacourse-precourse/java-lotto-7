package lotto.model;

import java.util.List;
import lotto.policy.PrizeMoneyPolicy;

public class Revenue {
    private final int budget;

    public Revenue(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public double rateOfReturn(List<PrizeMoneyPolicy> ranks) {
        long totalPrizeMoney = ranks.stream()
                .map(PrizeMoneyPolicy::getPriceMoney)
                .reduce(0L, Long::sum);

        return ((double)totalPrizeMoney / budget) * 100;
    }
}
