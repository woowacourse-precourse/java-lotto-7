package lotto;

import java.text.DecimalFormat;
import java.util.EnumMap;

public class LotteryResult {
    public static void printWinningResult(EnumMap<LotteryPrize, Integer> prizeCount) {
        System.out.println("\n당첨 통계\n---");
        for (LotteryPrize prize : LotteryPrize.values()) {
            System.out.println(prize.getDescription() + " (" + prize.getPrizeAmount() + "원) - " + prizeCount.getOrDefault(prize, 0) + "개");
        }
    }

    public static void printRateOfReturn(double result) {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("총 수익률은 " + df.format(result) + "%입니다.");
    }

    public static double calculateRateOfReturn(EnumMap<LotteryPrize, Integer> prizeCount, int lotteryPurchaseAmount) {
        double sum = 0;
        for (LotteryPrize prize : LotteryPrize.values()) {
            sum += prizeCount.getOrDefault(prize, 0) * prize.getPrizeAmount();
        }
        double result = sum / lotteryPurchaseAmount * 100;
        if (sum == 0) {
            result = 0;
        }

        return result;
    }
}
