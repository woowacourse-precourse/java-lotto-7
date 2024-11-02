package lotto.game;

import lotto.dto.LottoPrize;
import lotto.io.OutputHandler;

import java.util.HashMap;
import java.util.Map;

public class LottoPrizeRecord {
    private final Map<LottoPrize, Integer> result = new HashMap<>();

    public LottoPrizeRecord() {
        result.put(LottoPrize.THREE, 0);
        result.put(LottoPrize.FOUR, 0);
        result.put(LottoPrize.FIVE, 0);
        result.put(LottoPrize.SIX, 0);
        result.put(LottoPrize.BONUS, 0);
    }

    public void updateResult(LottoPrize lottoPrize) {
        if (lottoPrize != null) {
            result.put(lottoPrize, result.get(lottoPrize)+1);
        }
    }

    public void printResult() {
        OutputHandler.printWinningStatistics();
        OutputHandler.printWinningCount(result);
    }

    public Map<LottoPrize, Integer> getResult() {
        return result;
    }

    public int computeWinningPrice() {
        int totalWinningPrice = 0;
        for (LottoPrize lottoPrize : result.keySet()) {
            Integer count = result.get(lottoPrize);
            if (count > 0) {
                int winningPrice = lottoPrize.getPrice() * count;
                totalWinningPrice += winningPrice;
            }
        }
        return totalWinningPrice;
    }
}
