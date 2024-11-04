package lotto.game;

import lotto.dto.LottoPrize;
import lotto.io.OutputHandler;

import java.util.HashMap;
import java.util.Map;

public class LottoPrizeRecord {
    private static final int INIT = 0;
    private final Map<LottoPrize, Integer> result = new HashMap<>();

    public LottoPrizeRecord() {
        result.put(LottoPrize.THREE, INIT);
        result.put(LottoPrize.FOUR, INIT);
        result.put(LottoPrize.FIVE, INIT);
        result.put(LottoPrize.SIX, INIT);
        result.put(LottoPrize.BONUS, INIT);
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
        int totalWinningPrice = INIT;
        for (LottoPrize lottoPrize : result.keySet()) {
            totalWinningPrice = hasLottoPrize(lottoPrize, totalWinningPrice);
        }
        return totalWinningPrice;
    }

    private int hasLottoPrize(LottoPrize lottoPrize, int totalWinningPrice) {
        Integer count = result.get(lottoPrize);
        if (count > 0) {
            int winningPrice = lottoPrize.getPrice() * count;
            totalWinningPrice += winningPrice;
        }
        return totalWinningPrice;
    }
}
