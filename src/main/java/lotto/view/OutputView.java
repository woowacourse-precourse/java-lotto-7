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

  }

  public void printYield(double yield) {

  }
}

