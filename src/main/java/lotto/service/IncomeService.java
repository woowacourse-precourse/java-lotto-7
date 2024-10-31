package lotto.service;

import java.util.Set;
import lotto.enums.PrizeAmount;

public class IncomeService {

    public Double rateOfReturn(int money, Set<PrizeAmount> prizeAmounts) {
        int winningsSum = 0;
        for (PrizeAmount p: prizeAmounts) {
            if (p != null) {
                winningsSum += p.getAmount();
            }
        }
        return ((double)winningsSum / money) * 100;
    }
}
