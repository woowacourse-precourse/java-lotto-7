package lotto.service;

import java.util.List;
import lotto.model.Lotto;

public interface LottosServiceInterface {
  List<Lotto> generateLottosByAmount(int amount);

  List<Integer> checkWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber);

  double calculateYield(List<Integer> winningCounts, int purchaseAmount);
}
