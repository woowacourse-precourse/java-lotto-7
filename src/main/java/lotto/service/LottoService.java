package lotto.service;

import lotto.model.Money;
import lotto.model.PrizeRank;
import lotto.model.PrizeStatistics;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.NumbersGenerator;
import lotto.model.lotto.WinningLotto;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoService {
    public List<Lotto> createLotto(Money money) {
        int countLotto = money.calculateCountLotto();

        return Stream.generate(() -> new Lotto(NumbersGenerator.generateSortedNumbers()))
                .limit(countLotto)
                .toList();
    }

    public PrizeStatistics calculateStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        PrizeStatistics prizeStatistics = PrizeStatistics.createPrizeStatistics();

        lottos.stream()
                .map(lotto -> {
                    int matchCount = winningLotto.countMatchNumbers(lotto);
                    boolean matchBonusNumber = winningLotto.isMatchBonusNumber(lotto);
                    return PrizeRank.of(matchCount, matchBonusNumber);
                })
                .forEach(prizeStatistics::addStatistic);

        return prizeStatistics;
    }

    public double calculateProfitRatio(Money money, PrizeStatistics prizeStatistics) {
        int profit = calculateTotalPrize(prizeStatistics);
        double ratio = money.calculateProfitRatio(profit);
        return ratio;
    }

    private int calculateTotalPrize(PrizeStatistics prizeStatistics) {
        Map<PrizeRank, Integer> statistics = prizeStatistics.getStatistics();

        int totalPrize = 0;
        for (PrizeRank prizeRank : EnumSet.range(PrizeRank.FIRST, PrizeRank.FIFTH)) {
            int count = statistics.getOrDefault(prizeRank, 0);
            int prize = prizeRank.getWinningMoney() * count;
            totalPrize += prize;
        }

        return totalPrize;
    }
}
