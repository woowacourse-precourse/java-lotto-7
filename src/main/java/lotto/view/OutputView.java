package lotto.view;

import lotto.model.Winnings;

import java.util.List;

public class OutputView {
    public static String OUTPUT_ORDER_NUMBER = "개를 구매했습니다.";
    public static String OUTPUT_TOTAL_PROFIT = "총 수익률은 %.1f%% 입니다.";

    public static void printOrderNumber(int order) {
        System.out.println(order + OUTPUT_ORDER_NUMBER);
    }

    public static void printWinningAmount(List<Integer> matchCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Winnings winnings : Winnings.values()) {
            int count = matchCount.get(winnings.getMatchCount());
            System.out.println(winnings.getFormattedMessage(count));
        }

    }

    public static void printTotalProfit(List<Integer> matchCount, double orderAmount){
        double winAmount = 0;
        for (Winnings winnings : Winnings.values()) {
            int count = matchCount.get(winnings.getMatchCount());
            winAmount += winnings.getPrize() * count;
        }
        double totalProfit = (winAmount / orderAmount) * 100; // 수익률 계산
        System.out.printf(OUTPUT_TOTAL_PROFIT,totalProfit);
        System.out.println();
    }
}
