package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.RankResult;
import lotto.domain.RankType;

public class StatisticsCalculator {
    private static final String FORMAT_DECIMAL = "%.1f";
    private static final int MULTIPLE_NUMBER = 1000;
    private static final int PERCENT = 100;
    private static final int MINIMUM_MATCH_COUNT = 3;
    private final Map<RankType, RankResult> statistics;

    public StatisticsCalculator() {
        this.statistics = new EnumMap<>(RankType.class);
        initializeRankResults();
    }

    public Map<RankType, RankResult> calculateStatistics(
        List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {

        for (Lotto lotto : lottos) {
            int matchCount = LottoMatchCalculator.countMatchedNumbers(lotto, winningNumbers);
            boolean bonusMatched = LottoMatchCalculator.isBonusMatched(lotto, matchCount, bonusNumber);
            incrementRankResult(matchCount, bonusMatched);
        }
        return statistics;
    }

    public String calculateEarningRate(int purchaseAmount) {
        int totalPrize = calculateTotalPrize();
        return String.format(FORMAT_DECIMAL,
            ((float) totalPrize / (purchaseAmount * MULTIPLE_NUMBER)) * PERCENT);
    }

    public int calculateTotalPrize() {
        return statistics.values().stream()
            .mapToInt(RankResult::getPrize)
            .sum();
    }

    private void initializeRankResults() {
        for (RankType rank : RankType.values()) {
            statistics.put(rank, new RankResult(rank));
        }
    }

    private void incrementRankResult(int matchCount, boolean bonusMatched) {
        if(matchCount >= MINIMUM_MATCH_COUNT) {
            RankType rank = RankType.getRank(matchCount, bonusMatched);
            statistics.get(rank).increment();
        }
    }
}
