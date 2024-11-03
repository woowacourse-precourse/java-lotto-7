package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;

import java.util.List;

public class LottoResultCalculator {
    public LottoResult calculateResults(List<Lotto> lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        int[] rankCounts = new int[6]; // 0: 3개 일치, 1: 4개 일치, 2: 5개 일치, 3: 5개 + 보너스 일치, 4: 6개 일치

        for (Lotto lotto : lottos) {
            int matchingCount = getMatchingCount(lotto.getNumbers(), winningNumber.getNumbers());
            if (matchingCount == 6) {
                rankCounts[4]++; // 1등
            } else if (matchingCount == 5) {
                if (bonusNumber.getBonus() != null && lotto.getNumbers().contains(bonusNumber.getBonus())) {
                    rankCounts[3]++; // 2등
                } else {
                    rankCounts[2]++; // 3등
                }
            } else if (matchingCount == 4) {
                rankCounts[1]++; // 4등
            } else if (matchingCount == 3) {
                rankCounts[0]++; // 5등
            }
        }

        int totalSpent = lottos.size() * PurchaseAmount.LOTTE_PRICE; // 총 구매 금액
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
