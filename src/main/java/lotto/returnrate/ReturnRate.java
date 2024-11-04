package lotto.returnrate;

import java.util.EnumMap;
import lotto.lotto.LottoResult;
import lotto.lotto.LottoWinning;

public class ReturnRate {

    private final LottoResult lottoResult;

    public ReturnRate(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public double calculateReturnRate(int purchaseAmount) {
        int totalWinningAmount = calculateTotalWinningAmount();

        return ((double) totalWinningAmount / purchaseAmount) * 100;
    }

    private int calculateTotalWinningAmount() {
        int totalAmount = 0;

        EnumMap<LottoWinning, Integer> winningCounts = lottoResult.getWinningCounts();
        for (LottoWinning lottoWinning : winningCounts.keySet()) {
            int amount = winningCounts.get(lottoWinning) * lottoWinning.getPrice();
            totalAmount += amount;
        }

//        for (LottoWinning winning : LottoWinning.values()) {
//            int amount = winning.getCount() * winning.getPrice();
//            totalAmount += amount;
//        }

        return totalAmount;
    }
}
