package lotto.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lotto.enums.PrizeAmount;

public class IncomeService {

    public Double rateOfReturn(int money, Map<PrizeAmount, Integer> prizeAmounts) {
        int winningsSum = 0;
        for (Entry<PrizeAmount, Integer> pr: prizeAmounts.entrySet()) {
            if (pr != null) {
                winningsSum += pr.getKey().getAmount() * pr.getValue();
            }
        }
        return ((double)winningsSum / money) * 100;
    }
}
