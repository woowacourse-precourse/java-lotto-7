package lotto.view;

import java.util.List;
import lotto.constants.LottoPrize;
import lotto.model.Lotto;

public class OutputView implements OutputViewInterface {

  public void printPurchaseCount(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public void printGeneratedLottos(List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      System.out.println(lotto.getNumbers());
    }
  }

  public void printWinningResults(List<Integer> winningCounts) {
    System.out.println("당첨 통계");
    System.out.println("---");

    LottoPrize[] prizes = LottoPrize.values();
    for (int i = 0; i < prizes.length; i++) {
      LottoPrize prize = prizes[i];
      System.out.println(formatWinningResult(prize, winningCounts.get(i)));
    }
  }

  public String formatWinningResult(LottoPrize prize, int winningCount) {
    if (prize == LottoPrize.SECOND) {
      return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
          prize.getMatchCount(),
          String.format("%,d", prize.getPrizeAmount()),
          winningCount);
    }
    return String.format("%d개 일치 (%s원) - %d개",
        prize.getMatchCount(),
        String.format("%,d", prize.getPrizeAmount()),
        winningCount);
  }

  public void printYield(double yield) {
    System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
  }
}

