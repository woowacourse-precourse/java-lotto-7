package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class LottoService implements LottosServiceInterface {

  @Override
  public int getNumOfLottos(int purchaseAmount){
    return purchaseAmount/1000;
  }
  @Override
  public List<Lotto> generateLottosByAmount(int numOfLottos) {
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < numOfLottos; i++) {
      lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
    }
    return lottos;
  }



  @Override
  public List<Integer> checkWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers,
      int bonusNumber) {
    List<Integer> winningCounts = Arrays.asList(0, 0, 0, 0,
        0);

    for (Lotto lotto : lottos) {
      long matchCount = lotto.getNumbers().stream()
          .filter(winningNumbers::contains)
          .count();

      if (matchCount == 3) {
        winningCounts.set(0, winningCounts.get(0) + 1);
      } else if (matchCount == 4) {
        winningCounts.set(1, winningCounts.get(1) + 1);
      } else if (matchCount == 5) {
        if (lotto.getNumbers().contains(bonusNumber)) {
          winningCounts.set(3, winningCounts.get(3) + 1);
        } else {
          winningCounts.set(2, winningCounts.get(2) + 1);
        }
      } else if (matchCount == 6) {
        winningCounts.set(4, winningCounts.get(4) + 1);
      }
    }
    return winningCounts;
  }

  @Override
  public double calculateYield(List<Integer> winningCounts, int purchaseAmount) {

    int totalPrize = (winningCounts.get(0) * Prize.FIFTH.getAmount()) +
        (winningCounts.get(1) * Prize.FOURTH.getAmount()) +
        (winningCounts.get(2) * Prize.THIRD.getAmount()) +
        (winningCounts.get(3) * Prize.SECOND.getAmount()) +
        (winningCounts.get(4) * Prize.FIRST.getAmount());

    double yield = (double) totalPrize / purchaseAmount * 100;

    return Math.round(yield * 10) / 10.0; // 소수점 둘째 자리에서 반올림
  }
}
