package lotto.util.calculator;

import java.util.Map;
import lotto.value.Rank;

public class LottoWinningTotalReturnCalculator {

    public double calculateReturn(int purchaseAmount, Map<Rank, Integer> statistics) {
        int totalRevenue = 0;
        for (Rank rank : statistics.keySet()) {
            totalRevenue += rank.getPrize() * statistics.getOrDefault(rank, 0);
        }
        if (totalRevenue == 0) {
            return 0;
        }
        return (double) totalRevenue / purchaseAmount * 100;
    }

}
