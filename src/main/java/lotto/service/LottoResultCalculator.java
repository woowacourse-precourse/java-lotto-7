package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;

import java.util.List;

public class LottoResultCalculator {
    public LottoResult calculateResults(List<Lotto> lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        int[] rankCounts = new int[5];

        for (Lotto lotto : lottos) {
            int matchingCount = getMatchingCount(lotto.getNumbers(), winningNumber.getNumbers());
            boolean hasBonus = bonusNumber.getBonus() != null && lotto.getNumbers().contains(bonusNumber.getBonus());

            Rank rank = Rank.getRank(matchingCount, hasBonus);
            if (rank != null) {
                rankCounts[rank.getIndex()]++;
            }
        }

        int totalSpent = lottos.size() * PurchaseAmount.LOTTE_PRICE;
        return new LottoResult(totalSpent, rankCounts);
    }

    private int getMatchingCount(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : userNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
