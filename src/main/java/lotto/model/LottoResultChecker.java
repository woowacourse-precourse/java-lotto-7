package lotto.model;

public class LottoResultChecker {

        public static double calculateProfit(int purchaseCount, int winningPrize) {
            double purchaseAmount = Lotto.LOTTO_PRICE * purchaseCount;
            double profitRate = (winningPrize / purchaseAmount) * 100;
            return Math.round(profitRate * 100.0) / 100.0;
        }
}
