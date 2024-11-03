package lotto.returnrate;

import lotto.lotto.LottoWinning;

public class ReturnRate {

    public double calculateReturnRate(int purchaseAmount) {
        int totalWinningAmount = calculateTotalWinningAmount();

        return ((double) totalWinningAmount / purchaseAmount) * 100;
    }

    private int calculateTotalWinningAmount() {
        int totalAmount = 0;

        for (LottoWinning winning : LottoWinning.values()) {
            int amount = winning.getCount() * winning.getPrice();
            totalAmount += amount;
        }

        return totalAmount;
    }
}
