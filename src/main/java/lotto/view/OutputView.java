package lotto.view;

import lotto.model.Order;
import lotto.model.enums.Winnings;
import java.util.List;

public class OutputView {

    public static String ORDER_NUMBER_MESSAGE = "개를 구매했습니다.";
    public static String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%% 입니다.";
    public static String PREFIX_WINNING_AMOUNT = "당첨 통계" + "\n---";
    public static final String WINNING_MESSAGE = "%d개 일치 (%,.0f원) - %d개";
    public static final String WINNING_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,.0f원) - %d개";
    private static final int BONUS_MATCH_INDEX = 7;

    public static void printOrderNumber(int order) {
        System.out.println(order + ORDER_NUMBER_MESSAGE);
    }

    public static void printWinningAmount(List<Integer> matchCount) {
        System.out.println(PREFIX_WINNING_AMOUNT);
        for (Winnings winnings : Winnings.values()) {
            int count = matchCount.get(winnings.getMatchCount());
            if(winnings == Winnings.SECOND) count = matchCount.get(BONUS_MATCH_INDEX); //
            System.out.println(formatWinningMessage(winnings, count));
        }
    }

    public static void printTotalProfit(Order userOrder) {
        double totalProfit = userOrder.calculateTotalProfit();
        System.out.printf(TOTAL_PROFIT_MESSAGE, totalProfit);
        System.out.println();
    }

    private static String formatWinningMessage(Winnings winnings, int count) {
        if (winnings == Winnings.SECOND) {
            return String.format(WINNING_BONUS_MESSAGE, winnings.getMatchCount(), winnings.getPrize(), count);
        }
        return String.format(WINNING_MESSAGE, winnings.getMatchCount(), winnings.getPrize(), count);
    }
}