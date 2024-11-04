package lotto.view.output;

public class ProfitOutputView {
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    public static void showProfitRate(double profitRate) {
        System.out.printf(PROFIT_MESSAGE, profitRate);
    }
}
