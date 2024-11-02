package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoService implements LottosServiceInterface {

  @Override
  public List<Lotto> generateLottosByAmount(int amount) {
    int numOfLottos = amount / 1000;
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < numOfLottos; i++) {
      lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
    }
    return lottos;
  }


  @Override
  public List<Integer> checkWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers,
      int bonusNumber) {
    return null;
  }


  @Override
  public float calculateYield(List<Integer> winningCounts, int purchaseAmount) {
    return 1;
  }
}
