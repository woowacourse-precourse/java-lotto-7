package lotto.view;

import lotto.domain.WinningPrice;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static String TICKET_QUANTITY_MESSAGE = "%s개를 구매했습니다.";
    private static String WINNING_STATISTICS_MESSAGE = "당첨통계";
    private static String BOUNDARY = "-";
    private static int BOUNDARY_REPEAT_COUNT = 3;
    private static String MATCH_COUNT = "%s개";
    private static String BLANK_BOUNDARY = " - ";
    private static String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";


    private OutputView() {
    }

    public static void printTicketQuantity(int ticketQuantity) {
        printBlank();
        System.out.printf(TICKET_QUANTITY_MESSAGE, ticketQuantity);
        printBlank();
    }

    public static void printLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Map<WinningPrice, Integer> lottoResult) {
        printBlank();
        printWinningStatisticMessage();
        printBoundary();
        printStatistics(lottoResult);
    }
    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printProfit(String formatProfit) {
        System.out.printf(PROFIT_MESSAGE, formatProfit);
    }

    private static void printStatistics(Map<WinningPrice, Integer> lottoResult) {
        for (WinningPrice winningPrice : lottoResult.keySet()) {
            if (winningPrice == WinningPrice.LOSE) {
                continue;
            }
            System.out.print(winningPrice.getDescription() + BLANK_BOUNDARY);
            printMatchCount(lottoResult.get(winningPrice));
        }

    }


    private static void printMatchCount(int count) {
        System.out.printf(MATCH_COUNT, count);
        printBlank();
    }

    private static void printBoundary() {
        System.out.println(BOUNDARY.repeat(BOUNDARY_REPEAT_COUNT));
    }

    private static void printWinningStatisticMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    private static void printBlank() {
        System.out.println();
    }

}
