package lotto.view;


public class ProfitOutputView {

    private static final String PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE_FORMAT, profitRate);
    }
}
