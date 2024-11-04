package lotto.domain.calculator;

import lotto.domain.result.LottoRank;
import lotto.domain.result.WinningStatistics;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningCalculator {
    public WinningStatistics calculate(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = initializeRankCounts();
        List<Lotto> lottoList = lottos.getLottos();

        for (Lotto lotto : lottoList) {
            LottoRank rank = winningLotto.match(lotto);
            addCount(rankCounts, rank);
        }

        return WinningStatistics.from(rankCounts);
    }

    private Map<LottoRank, Integer> initializeRankCounts() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    private void addCount(Map<LottoRank, Integer> rankCounts, LottoRank rank) {
        int currentCount = rankCounts.getOrDefault(rank, 0);
        rankCounts.put(rank, currentCount + 1);
    }
}