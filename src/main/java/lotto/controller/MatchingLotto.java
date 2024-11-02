package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.OutputView;

public class MatchingLotto {
    static void matchingLotto(List<Lotto> lottoList, Lotto winningNumbers, int bonusNumber, int purchaseAmount) {
        Map<Rank, Integer> resultMap = new HashMap<>();

        for (Lotto lotto : lottoList) {
            int matchCount = getCount(lotto, winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.getRank(matchCount, bonusMatch);
            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
        OutputView.printResultList(resultMap);

        double profit = CalculateProfit.calculateProfit(resultMap, purchaseAmount);
        OutputView.printResultProfit(profit);

    }

    private static int getCount(Lotto lotto, Lotto winningNumbers) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}