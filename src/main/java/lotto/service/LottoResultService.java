package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.common.Constants;
import lotto.domain.Lotto;
import lotto.domain.Winning;

public class LottoResultService {
    public Map<Winning, Integer> getWinnings(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        Map<Winning, Integer> winningsCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            Winning winning = lotto.checkWinnings(winningNumbers, bonus);
            winningsCount.put(winning, winningsCount.getOrDefault(winning, 0) + 1);
        }

        return winningsCount;
    }

    public double calculateYield(int payment, int totalWinnings) {
        double yield = totalWinnings / (double) payment;

        return Math.round(yield * Constants.ROUNDING_SCALE) / Constants.YIELD_DIVISOR;
    }

    public int calculateTotalWinnings(Map<Winning, Integer> winnings) {
        Set<Winning> winningSet = winnings.keySet();
        int totalWinnings = 0;

        for (Winning winning : winningSet) {
            int count = winnings.get(winning);
            totalWinnings += count * winning.getPrize();
        }

        return totalWinnings;
    }
}
