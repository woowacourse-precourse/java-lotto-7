package lotto.view;

public class OutputView {
    private static final String LOTTO_TICKET_OUTPUT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_OUTPUT_MESSAGE = "당첨 통계";
    private static final String PROFIT_RATE_OUTPUT_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    public static void printResult(String result) {
        System.out.println(result);
    }

    public void printLottoTicket(int ticketCount) {
        printWhiteSpace();
        System.out.println(ticketCount + LOTTO_TICKET_OUTPUT_MESSAGE);
    }

    public void printWinningStatistics() {
        printWhiteSpace();
        System.out.println(WINNING_STATISTICS_OUTPUT_MESSAGE);
        System.out.println("---");
    }

    public void printProfitRate(float profitRate) {
        System.out.printf(PROFIT_RATE_OUTPUT_MESSAGE, profitRate);
    }

    private static void printWhiteSpace() {
        System.out.println();
    }


}
