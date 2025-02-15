package lotto;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class PrizeCounter {

  private final Map<Calculator.WinningType, Integer> prizeCount = new HashMap<>();
  private static final int FIRST_PRIZE_AMOUNT = 2_000_000_000;
  private static final int SECOND_PRIZE_AMOUNT = 30_000_000;
  private static final int THIRD_PRIZE_AMOUNT = 1_500_000;
  private static final int FOURTH_PRIZE_AMOUNT = 50_000;
  private static final int FIFTH_PRIZE_AMOUNT = 5_000;
  private static final String FIRST_PRIZE_FORMAT = "6개 일치 (%s원) - %d개\n";
  private static final String SECOND_PRIZE_FORMAT = "5개 일치, 보너스 볼 일치 (%s원) - %d개\n";
  private static final String THIRD_PRIZE_FORMAT = "5개 일치 (%s원) - %d개\n";
  private static final String FOURTH_PRIZE_FORMAT = "4개 일치 (%s원) - %d개\n";
  private static final String FIFTH_PRIZE_FORMAT = "3개 일치 (%s원) - %d개\n";

  public PrizeCounter() {
    for (Calculator.WinningType type : Calculator.WinningType.values()) {
      prizeCount.put(type, 0);
    }
  }

  public void incrementPrizeCount(Calculator.WinningType prizeType) {
    prizeCount.put(prizeType, prizeCount.get(prizeType) + 1);
  }

  public void printPrizeCount() {
    System.out.println("당첨 통계\n---");
    NumberFormat numberFormat = NumberFormat.getInstance();

    System.out.printf(FIFTH_PRIZE_FORMAT, numberFormat.format(FIFTH_PRIZE_AMOUNT),
        prizeCount.getOrDefault(Calculator.WinningType.FIFTH_PRIZE, 0));
    System.out.printf(FOURTH_PRIZE_FORMAT, numberFormat.format(FOURTH_PRIZE_AMOUNT),
        prizeCount.getOrDefault(Calculator.WinningType.FORTH_PRIZE, 0));
    System.out.printf(THIRD_PRIZE_FORMAT, numberFormat.format(THIRD_PRIZE_AMOUNT),
        prizeCount.getOrDefault(Calculator.WinningType.THIRD_PRIZE, 0));
    System.out.printf(SECOND_PRIZE_FORMAT, numberFormat.format(SECOND_PRIZE_AMOUNT),
        prizeCount.getOrDefault(Calculator.WinningType.SECOND_PRIZE, 0));
    System.out.printf(FIRST_PRIZE_FORMAT, numberFormat.format(FIRST_PRIZE_AMOUNT),
        prizeCount.getOrDefault(Calculator.WinningType.FIRST_PRIZE, 0));
  }

  public Map<Calculator.WinningType, Integer> getPrizeCount() {
    return this.prizeCount;
  }


}


