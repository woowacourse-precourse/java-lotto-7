package lotto.model;

import java.util.List;
import java.util.Set;

public class LottoResultChecker {

    public static Ranking matchCount(Set<Integer> winningLotto, List<Lotto> issuedLotto,
            int bonusNumber) {
        int count = 0;
        for (Lotto lotto : issuedLotto) {
            for (int number : lotto.getNumbers()) {
                if (winningLotto.contains(number)) {
                    count++;
                }
            }
        }

        boolean isMatchBonus = false;
        for (Lotto lotto : issuedLotto) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                isMatchBonus = true;
                break;
            }
        }
        return determineRanking (count, isMatchBonus);
    }

    private static Ranking determineRanking(int count, boolean isMatchBonus) {
        if (Ranking.valueOf(count, isMatchBonus).equals(Ranking.FIRST)) {
            return Ranking.FIRST;
        }
        if (Ranking.valueOf(count, isMatchBonus).equals(Ranking.SECOND)) {
            return Ranking.SECOND;
        }
        if (Ranking.valueOf(count, isMatchBonus).equals(Ranking.THIRD)) {
            return Ranking.THIRD;
        }
        if (Ranking.valueOf(count, isMatchBonus).equals(Ranking.FOURTH)) {
            return Ranking.FOURTH;
        }
        if (Ranking.valueOf(count, isMatchBonus).equals(Ranking.FIFTH)) {
            return Ranking.FIFTH;
        }
        return Ranking.NONE;
    }

    public static double calculateProfit(int purchaseCount, int winningPrize) {
        double purchaseAmount = Lotto.LOTTO_PRICE * purchaseCount;
        double profitRate = (winningPrize / purchaseAmount) * 100;
        return Math.round(profitRate * 100.0) / 100.0;
    }
}
