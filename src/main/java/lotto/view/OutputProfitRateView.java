package lotto.view;

public class OutputProfitRateView {

  private static final String MESSAGE_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

  public static void printProfitRate(double profitRate) {
    System.out.println(String.format(MESSAGE_PROFIT_RATE, profitRate));
  }
}
