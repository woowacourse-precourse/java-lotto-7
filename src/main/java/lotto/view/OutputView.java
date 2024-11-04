package lotto.view;

import java.util.Collections;
import java.util.List;
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
    System.out.println("3개 일치 (5,000원) - " + winningCounts.get(0) + "개");
    System.out.println("4개 일치 (50,000원) - " + winningCounts.get(1) + "개");
    System.out.println("5개 일치 (1,500,000원) - " + winningCounts.get(2) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCounts.get(3) + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + winningCounts.get(4) + "개");
  }

  public void printYield(double yield) {

  }
}

