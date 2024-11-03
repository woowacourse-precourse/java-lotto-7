package lotto.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResultChecker {

    public static Map<Ranking, Integer> calculateRankingCount(Set<Integer> winningLotto,
            List<Lotto> issuedLotto, int bonusNumber) {
        Map<Ranking, Integer> rankingCountMap = new EnumMap<>(Ranking.class);

        for (Lotto lotto : issuedLotto) {
            int matchCount = countMatches(winningLotto, lotto);
            boolean isMatchBonus = lotto.getNumbers().contains(bonusNumber);
            Ranking ranking = determineRanking(matchCount, isMatchBonus);
            rankingCountMap.put(ranking, rankingCountMap.getOrDefault(ranking, 0) + 1);
        }
        return rankingCountMap;
    }

    private static int countMatches(Set<Integer> winningLotto, Lotto lotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static Ranking determineRanking(int count, boolean isMatchBonus) {
        return Ranking.valueOf(count, isMatchBonus);
    }

    public static int calculateWinningPrize(Map<Ranking, Integer> rankingIntegerMap) {
        int totalPrize = 0;
        for (Ranking ranking : rankingIntegerMap.keySet()) {
            totalPrize += ranking.getPrize() * rankingIntegerMap.get(ranking);
        }
        return totalPrize;
    }

    public static double calculateProfit(int purchaseCount, int winningPrize) {
        double purchaseAmount = Lotto.LOTTO_PRICE * purchaseCount;
        double profitRate = (winningPrize / purchaseAmount) * 100;
        return Math.round(profitRate * 100.0) / 100.0;
    }
}
