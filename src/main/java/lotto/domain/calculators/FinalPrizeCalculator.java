package lotto.domain.calculators;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Rank;

public class FinalPrizeCalculator {

    public long calculate(EnumMap<Rank, Integer> matchedRanks) {
        long result = 0;

        for (Map.Entry<Rank, Integer> entry : matchedRanks.entrySet()) {
            Rank rank = entry.getKey();
            int matchedCount = entry.getValue();
            long prizeMoney = rank.getPrizeMoney();

            if (isMatchedRank(matchedCount)) {
                result += calculatePrizeBasedCount(matchedCount, prizeMoney);
            }
        }
        return result;
    }

    private long calculatePrizeBasedCount(int matchedCount, long prizeMoney) {
        return prizeMoney * matchedCount;
    }

    private boolean isMatchedRank(int matchedCount) {
        return matchedCount > 0;
    }

}
