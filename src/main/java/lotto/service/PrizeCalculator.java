package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

import java.util.List;

public class PrizeCalculator {

    public Rank calculateRank(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = calculateMatchCount(lotto, winningNumbers.getWinningNumbers());
        boolean bonusMatch = lotto.getNumbers().contains(winningNumbers.getBonusNumber());

        return Rank.valueOf(matchCount, bonusMatch);
    }

    public int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int calculateTotalPrize(List<Lotto> lottos, WinningNumbers winningNumbers) {
        int totalPrize = 0;
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumbers);
            totalPrize += rank.getPrize();
        }
        return totalPrize;
    }
}
