package lotto.domain.calculator;

import lotto.domain.result.LottoRank;
import lotto.domain.result.WinningStatistics;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.WinningLotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningCalculator {
    public WinningStatistics calculate(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = initializeRankCounts();
        updateRankCounts(rankCounts, lottos, winningLotto);
        return WinningStatistics.from(rankCounts);
    }

    private Map<LottoRank, Integer> initializeRankCounts() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        initializeAllRanks(rankCounts);
        return rankCounts;
    }

    private void initializeAllRanks(Map<LottoRank, Integer> rankCounts) {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    private void updateRankCounts(Map<LottoRank, Integer> rankCounts, Lottos lottos, WinningLotto winningLotto) {
        lottos.applyToEachLotto((lotto) -> {
            LottoRank rank = winningLotto.calculateRank(lotto);
            addCount(rankCounts, rank);
        });
    }

    private void addCount(Map<LottoRank, Integer> rankCounts, LottoRank rank) {
        int count = rankCounts.getOrDefault(rank, 0);
        rankCounts.put(rank, count + 1);
    }
}