package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class StatisticsGenerator {
    private final Map<LottoRank, Integer> statistics = new HashMap<>();
    private final LottoRankCalculator lottoRankCalculator;

    public StatisticsGenerator(LottoRankCalculator lottoRankCalculator) {
        this.lottoRankCalculator = lottoRankCalculator;
        statisticsInitializer();
    }

    private void statisticsInitializer() {
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }
    }

    public void makeStatistics(List<Lotto> lotto, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lottoNumbers : lotto) {
            LottoRank rank = lottoRankCalculator.getLottoPrizeRank(lottoNumbers.getNumbers(),
                    winningNumbers.getNumbers(), bonusNumber);
            putCountingIntoStatistics(rank);
        }
    }

    private void putCountingIntoStatistics(LottoRank rank) {
        if (statistics.containsKey(rank)) {
            statistics.put(rank, statistics.get(rank) + 1);
            return;
        }
        statistics.put(rank, 1);
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }
}
