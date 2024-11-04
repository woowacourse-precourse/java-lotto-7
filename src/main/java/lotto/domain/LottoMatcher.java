package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoMatcher {

    public void matcher(List<Lotto> lotteries, WinningNumber winningNumber, int totalspent) {
        Map<RankingEnum, Long> result = matchCount(lotteries, winningNumber);
        printResults(result);
        double rateOfReturn = calculateRateOfReturn(result, totalspent);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }

    Map<RankingEnum, Long> matchCount(List<Lotto> lotteries, WinningNumber winningNumber) {
        return lotteries.stream()
                .map(lotto -> findRankByMatch(lotto.matchCount(winningNumber), lotto.containsBonus(winningNumber)))
                .filter(rank -> rank != null)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    RankingEnum findRankByMatch(long matchCount, boolean bonusNumber) {
        if (matchCount == 6) {
            return RankingEnum.SIX_MATCH;
        }
        if (matchCount == 5 && bonusNumber) {
            return RankingEnum.BONUS_MATCH;
        }
        if (matchCount == 5) {
            return RankingEnum.FIVE_MATCH;
        }
        if (matchCount == 4) {
            return RankingEnum.FOUR_MATCH;
        }
        if (matchCount == 3) {
            return RankingEnum.TREE_MATCH;
        }
        return null;
    }

    private void printResults(Map<RankingEnum, Long> result) {
        for (RankingEnum rank : RankingEnum.values()) {
            long count = result.getOrDefault(rank, 0L);
            System.out.printf("%s - %d개\n", rank.getMessage(), count);
        }
    }

    double calculateRateOfReturn(Map<RankingEnum, Long> result, int totalSpent) {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue().intValue())
                .sum();

        if (totalSpent == 0) {
            return 0.0;
        }
        double rateOfReturn = ((double) totalPrize / totalSpent) * 100;
        return Math.round(rateOfReturn * 10) / 10.0;
    }
}