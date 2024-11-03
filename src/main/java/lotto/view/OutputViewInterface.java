package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public interface OutputViewInterface {

  void printPurchaseCount(int count);

  void printGeneratedLottos(List<Lotto> lottos);

  void printWinningResults(List<Integer> result);

  void printYield(double yield);
}
