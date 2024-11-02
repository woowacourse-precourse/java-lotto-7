package lotto.domain.lottos.user;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Rank;
import lotto.domain.calculators.FinalPrizeCalculator;

public class WinningRank {
    private final FinalPrizeCalculator finalPrizeCalculator;

    private final EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);

    public WinningRank(FinalPrizeCalculator finalPrizeCalculator) {
        this.finalPrizeCalculator = finalPrizeCalculator;
        initRanks();
    }

    public void addAllMatchedRank(List<Rank> matchedResults) {
        for (Rank rank : matchedResults) {
            ranks.merge(rank, 1, Integer::sum);
        }
    }

    public long calculateTotalPrizeAmount() {
        return finalPrizeCalculator.calculate(ranks);
    }

    public EnumMap<Rank, Integer> getWinningStatistics() {
        return ranks;
    }


    private void initRanks() {
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
    }

}
