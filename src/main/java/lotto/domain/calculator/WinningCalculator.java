package lotto.domain.calculator;

import lotto.domain.result.LottoRank;
import lotto.domain.result.WinningStatistics;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.WinningLotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningCalculator {
    public WinningStatistics calculate(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = initializeRankCounts();
        countWinningResults(lottos, winningLotto, rankCounts);
        return WinningStatistics.from(rankCounts);
    }

    private Map<LottoRank, Integer> initializeRankCounts() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    private void countWinningResults(
            Lottos lottos,
            WinningLotto winningLotto,
            Map<LottoRank, Integer> rankCounts) {
        lottos.forEach(lotto -> {
            LottoRank rank = winningLotto.match(lotto);
            addCount(rankCounts, rank);
        });
    }

    private void addCount(Map<LottoRank, Integer> rankCounts, LottoRank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }
}