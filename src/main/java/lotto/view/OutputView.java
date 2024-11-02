package lotto.view;

public class OutputView {

    private static final String PURCHASE_LOTTOS_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseInfo(int count, String details) {
        printPurchaseLottosCount(count);
        printPurchaseLottosNumbers(details);
    }

    private static void printPurchaseLottosCount(int count) {
        System.out.printf(PURCHASE_LOTTOS_MESSAGE, count);
        System.out.println();
    }

    private static void printPurchaseLottosNumbers(String numbers) {
        System.out.println(numbers);
    }

    public static void printResult(String statistics, float rateOfReturn) {
        System.out.println(STATISTICS_MESSAGE);
        printStatistics(statistics);
        printRateOfReturn(rateOfReturn);
    }

    private static void printStatistics(String statistics) {
        System.out.println(statistics);
    }

    private static void printRateOfReturn(float rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
