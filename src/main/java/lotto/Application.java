package lotto;

import lotto.entity.Consumer;
import lotto.entity.LottoYieldCalculator;
import lotto.entity.Rank;
import lotto.entity.WinningLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        int totalCost = consumer.getTotalLottoCost();
        LottoYieldCalculator calculator = new LottoYieldCalculator(totalCost);

        Set<Integer> winningNumbers = Lotto.getWinningNumbers();
        int bonusNumber = Lotto.getBonusNumberInput();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int[] matchCounts = calculateMatchCounts(consumer.getLottoTickets(), winningLotto, calculator);

        winningLotto.printWinningStatistics(matchCounts);
        calculator.printYield();
    }

    private static int[] calculateMatchCounts(List<List<Integer>> userTickets, WinningLotto winningLotto, LottoYieldCalculator calculator) {
        int[] matchCounts = new int[Rank.values().length];
        for (List<Integer> userNumbers : userTickets) {
            Rank rank = winningLotto.getRank(new HashSet<>(userNumbers));
            matchCounts[rank.ordinal()]++;
            calculator.addPrize(rank.getPrize());
        }
        return matchCounts;
    }
}
