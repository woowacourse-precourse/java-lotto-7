package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LotteryStatistics {

    private final Map<LottoPrize, Integer> statistics;
    private final Budget budget;

    private LotteryStatistics(Lotties lotties, WinningLotto winningLotto, Budget budget) {
        statistics = new EnumMap<>(LottoPrize.class);
        for (Lotto lotto : lotties.getLottoTickets()) {
            LottoPrize prize = lotto.scratch(winningLotto);
            statistics.put(prize, statistics.getOrDefault(prize, 0) + 1);
        }
        this.budget = budget;
    }

    public static LotteryStatistics of(Lotties lotties, WinningLotto winningLotto, Budget budget) {
        return new LotteryStatistics(lotties, winningLotto, budget);
    }

    public int getWonCount(LottoPrize lottoPrize) {
        return statistics.getOrDefault(lottoPrize, 0);
    }

    public double computeReturnOfInvestment() {
        double total = 0.0d;
        for (Entry<LottoPrize, Integer> prize : statistics.entrySet()) {
            total += prize.getKey().prize() * prize.getValue();
        }
        return (double) Math.round(total * 1000 / budget.getAmount()) / 10;
    }
}
