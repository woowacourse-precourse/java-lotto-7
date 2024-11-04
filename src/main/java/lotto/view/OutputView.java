package lotto.view;

import java.util.List;

public class OutputView {

  private static final String RESULT_MSG = "\n당첨 통계\n---";
  private static final String PURCHASED_LOTTO_MSG = "\n%d개를 구매했습니다.\n";
  private static final String WINNING_STATISTICS = "%s - %d개\n";
  private static final String EARNING_RATE = "총 수익률은 %s입니다.\n";

  public void printResult() {
    System.out.println(RESULT_MSG);
  }

  public void printLottoSize(int purchasedLottoCount) {
    System.out.printf(PURCHASED_LOTTO_MSG, purchasedLottoCount);
  }

  public void printLottos(List<Integer> numbers) {
    System.out.println(numbers);
  }

  public void printWinningStatistics(String message, int count) {
    System.out.printf(WINNING_STATISTICS, message, count);
  }

  public void printEarningRate(double earningRate) {
    System.out.printf(EARNING_RATE, String.format("%.1f%%", earningRate));
  }
}