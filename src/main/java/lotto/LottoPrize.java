package lotto;

import java.util.List;

public enum LottoPrize {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int numberMatchCount;
    private final boolean bonusNumberRequired;
    private final int prize;

    LottoPrize(int numberMatchCount, boolean bonusNumber, int prize) {
        this.numberMatchCount = numberMatchCount;
        this.bonusNumberRequired = bonusNumber;
        this.prize = prize;
    }

    public static void getIndividualResult(int matchCount, boolean matchBonusNumber,
                                           List<Integer> prizeCount) {
        for (LottoPrize rank : LottoPrize.values()) {
            if (rank.numberMatchCount == matchCount
                    && rank.bonusNumberRequired == matchBonusNumber) {
                prizeCount.set(rank.ordinal(), prizeCount.get(rank.ordinal()) + 1);
            }
        }
    }

    public static void printResult(List<Integer> prizeCount) {
        System.out.println("\n당첨 통계\n---");

        for (LottoPrize rank : LottoPrize.values()) {
            System.out.print(rank.numberMatchCount + "개 일치");
            if (rank.bonusNumberRequired) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(String.format(" (%,d원) - %,d개\n", rank.prize,
                    prizeCount.get(rank.ordinal())));
        }
    }

    public static void calculateProfitRate(List<Integer> prizeCount, int paymentAmount) {
        double totalProfit = 0;

        for (LottoPrize rank : LottoPrize.values()) {
            totalProfit += prizeCount.get(rank.ordinal()) * rank.prize;
        }

        String profitRate = String.format("%.1f", totalProfit / paymentAmount * 100);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
