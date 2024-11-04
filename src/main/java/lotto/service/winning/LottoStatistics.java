package lotto.service.winning;

import java.util.List;
import lotto.domain.Rank;

public class LottoStatistics {

    private final List<Rank> ranks;
    private final double profitRate;

    public LottoStatistics(List<Rank> ranks, double profitRate) {
        this.ranks = ranks;
        this.profitRate = profitRate;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
