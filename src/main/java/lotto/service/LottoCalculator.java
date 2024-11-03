package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;

public class LottoCalculator {

    public static LottoRank calculateRank(Lotto userLotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;

        for (int number : userLotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
        return LottoRank.findRank(matchCount, bonusMatch);
    }

    public static double calculateReturn(int totalPrizeAmount, int purchaseAmount) {
        double result = (double) totalPrizeAmount / purchaseAmount * 100.0;
        return Math.round(result * 100.0) / 100.0;
    }
}
