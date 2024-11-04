package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.RankCalculator;
import lotto.model.Statics;
import lotto.model.WinningNumber;
import lotto.util.IoComponent;
import lotto.util.common.Limit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class RankCalculatorController {
    private final RankCalculator rankCalculator;
    private final WinningNumber winningNumber;
    private final IoComponent ioComponent;

    public RankCalculatorController(WinningNumber winningNumber, IoComponent ioComponent, RankCalculator rankCalculator) {
        this.rankCalculator = rankCalculator;
        this.winningNumber = winningNumber;
        this.ioComponent = ioComponent;
    }

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos) {
        List<Rank> ranks = rankCalculator.compareLottos(lottos, this.winningNumber);
        return rankCalculator.finalRank(ranks);
    }

    public void printResult(Map<Rank, Integer> result) {
        ioComponent.getOutputView().printStaticsFormat();
        List<Rank> sortedRanks = sortRanks();
        sortedRanks.forEach(rank -> printSingleResult(rank, result));
    }

    private List<Rank> sortRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.comparingInt(Rank::getPrize))
                .toList();
    }

    private void printSingleResult(Rank rank, Map<Rank, Integer> result) {
        int rankCount = result.getOrDefault(rank, Limit.DEFAULT.getValue());
        ioComponent.getOutputView().printWinningResult(rank.getCountOfMatch(), rank.getPrize(), rankCount);

    }

    public float calculateProfit(Map<Rank, Integer> result, int ticketCount) {
        int totalPrize = calculateTotalPrize(result);
        int totalSpent = ticketCount * Limit.UNIT_PRICE.getValue();
        return new Statics().calculateProfit(totalSpent, totalPrize);
    }

    private int calculateTotalPrize(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
