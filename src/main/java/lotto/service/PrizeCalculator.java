package lotto.service;

import java.util.Map;
import lotto.model.rank.Rank;
import lotto.model.rank.RankResult;

public class PrizeCalculator {

    public double calculate(RankResult rankResult) {
        double totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : rankResult.getRankCounts().entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }

        return totalPrize;
    }

}
