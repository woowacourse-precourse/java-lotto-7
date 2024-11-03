package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<LottoPrize, Integer> prizeCount;

    public WinningStatistics() {
        this.prizeCount = new HashMap<>();
        initializePrizeCount();
    }

    private void initializePrizeCount() {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public void calculateCount(List<Lotto> purchasedLotto, WinningPrize winningPrize) {
        for (Lotto lotto : purchasedLotto) {
            LottoPrize prize = winningPrize.getPrize(lotto);
            if (prize != null) {
                increase(prize);
            }
        }
    }

    private void increase(LottoPrize prize) {
        prizeCount.put(prize, prizeCount.get(prize) + 1);
    }

    public void display() {
        System.out.println("당첨 통계\n---");
        for (LottoPrize prize : LottoPrize.values()) {
            int count = prizeCount.getOrDefault(prize, 0);
            System.out.printf("%s - %d개\n", prize, count);
        }
    }

    public double calculateTotalProfit(int purchaseAmount) {
        int totalPrizeAmount = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            int count = prizeCount.getOrDefault(prize, 0);
            totalPrizeAmount += count * prize.getPrizeAmount();
        }

        double yield = (double) totalPrizeAmount / purchaseAmount * 100;

        return Math.round(yield * 10) / 10.0;
    }
}
