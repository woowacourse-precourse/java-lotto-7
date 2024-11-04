package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LotteryStatistics {

    private final Map<LottoPrize, Integer> statistics;

    private LotteryStatistics(Lotties lotties, WinningLotto winningLotto) {
        statistics = new EnumMap<>(LottoPrize.class);
        for (Lotto lotto: lotties.getLottoTickets()) {
            LottoPrize prize = lotto.scratch(winningLotto);
            statistics.put(prize, statistics.getOrDefault(prize, 0) + 1);
        }
    }

    public static LotteryStatistics of(Lotties lotties, WinningLotto winningLotto) {
        return new LotteryStatistics(lotties, winningLotto);
    }

    public Integer getWonCount(LottoPrize lottoPrize) {
        return statistics.getOrDefault(lottoPrize, 0);
    }
}
