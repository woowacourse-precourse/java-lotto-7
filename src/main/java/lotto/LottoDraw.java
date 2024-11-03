package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoDraw {
    private final Map<LottoPrize, Integer> prizeCount;

    public LottoDraw() {
        this.prizeCount = new EnumMap<>(LottoPrize.class);
        initializePrizeCount();
    }

    private void initializePrizeCount() {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public void countWinningResult(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = lotto.matchCount(winningNumber.getWinningNumbers());
        boolean bonusMatch = matchCount == 5 &&
                lotto.containsNumber(winningNumber.getBonusNumber());

        updatePrizeCount(matchCount, bonusMatch);
    }

    private void updatePrizeCount(int matchCount, boolean bonusMatch) {
        LottoPrize prize = findPrize(matchCount, bonusMatch);
        if (prize != null) {
            increasePrizeCount(prize);
        }
    }

    private LottoPrize findPrize(int matchCount, boolean bonusMatch) {
        if (matchCount == LottoPrize.FIRST.getMatchCount()) {
            return LottoPrize.FIRST;
        }
        if (matchCount == LottoPrize.SECOND.getMatchCount() && bonusMatch) {
            return LottoPrize.SECOND;
        }
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.getMatchCount() == matchCount && prize != LottoPrize.SECOND)
                .findFirst()
                .orElse(null);
    }

    private void increasePrizeCount(LottoPrize prize) {
        prizeCount.put(prize, prizeCount.get(prize) + 1);
    }

    public void printResults(int purchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> System.out.printf("%s (%,d원) - %d개\n",
                        prize.getDescription(),
                        prize.getPrize(),
                        prizeCount.get(prize)));

        printProfitRate(purchaseAmount);
    }

    private void printProfitRate(int purchaseAmount) {
        double totalPrize = 0;
        for (Map.Entry<LottoPrize, Integer> entry : prizeCount.entrySet()) {
            int prize = entry.getKey().getPrize();
            int count = entry.getValue();
            totalPrize += (long) prize * count;
        }
        double profitRate = (totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
