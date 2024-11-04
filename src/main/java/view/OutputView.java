package view;

import lotto.Winning;

import java.util.Map;

public class OutputView {
    private OutputView() {}

    public static void printResult(Map<Winning, Integer> resultCount) {
        System.out.println(ViewMessage.PRINT_RESULT);
        for (Winning winning : Winning.values()) {
            if (winning.getWinnings() > 0) {
                int count = resultCount.get(winning);
                System.out.printf("%d개 일치 (%d원) - %d개\n",
                winning.getNumberMatches(), winning.getWinnings(), count);
            }
        }
    }


    public static void printProfit(double profit) {
        System.out.print(ViewMessage.PRINT_PROFIT);
        System.out.println(profit + "%입니다");
    }

}
