package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeSettle {
    private final CompareNumbers compareNumbers = new CompareNumbers();
    private Map<Prize, Integer> resultCounts = new HashMap<>();

    private void formatPrizeMap() {
        for (Prize prize : Prize.values()) {
            resultCounts.put(prize, 0);
        }
    }
    public PrizeSettle(List<Lotto> purchasedLotto, List<Integer> winningNumbers, int bonusNumber) {
        formatPrizeMap();
        for(Lotto lotto : purchasedLotto) {
            List<Integer> yourNumbers = lotto.getNumbers();
            int count = compareNumbers.checkSameCount(yourNumbers, winningNumbers);
            boolean bonusResult = compareNumbers.checkBonus(bonusNumber, yourNumbers);

            Prize prize = determinePrize(count, bonusResult);
            resultCounts.put(prize, resultCounts.get(prize) + 1);
        }
    }

    private Prize determinePrize(int count, boolean bonusNumber) {
        for(Prize prize : Prize.values()) {
            if(prize.compareLottoNumbers(count, bonusNumber) == prize.getIndex()) {
                return prize;
            }
        }
        return Prize.NONE;
    }

    public Map<Prize, Integer> getResultCounts() {
        return resultCounts;
    }
}
