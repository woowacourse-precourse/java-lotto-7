package lotto.io.printer;

import lotto.LottoPrize;

public final class ResultPrinter {

    private static final String RESULT_HEADER = "당첨 통계\n---";
    private static final String PRIZE_RESULT_FORMAT = "%s - %d개";
    private static final String PROFIT_RESULT_PREFIX = "총 수익률은 ";
    private static final String PROFIT_RESULT_SUFFIX = "%입니다.";

    private ResultPrinter() {
    }

    public static void printResultHeader() {
        DefaultPrinter.printLine(RESULT_HEADER);
    }

    public static void printPrizeResult(final LottoPrize prize, final long matchCount) {
        String result = String.format(PRIZE_RESULT_FORMAT, prize.getDescription(), matchCount);
        DefaultPrinter.printLine(result);
    }

    public static void printTotalProfit(final double profit) {
        String result = String.join(String.valueOf(profit), PROFIT_RESULT_PREFIX, PROFIT_RESULT_SUFFIX);
        DefaultPrinter.printLine(result);
    }

}
