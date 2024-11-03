package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
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
    // 결과 리스트 초기화
    List<Integer> winningCounts = Arrays.asList(0, 0, 0, 0,
        0); // [3개 일치, 4개 일치, 5개 일치, 5개 + 보너스 일치, 6개 일치]

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
  public float calculateYield(List<Integer> winningCounts, int purchaseAmount) {

    int totalPrize = (winningCounts.get(0) * Prize.FIFTH.getAmount()) +
        (winningCounts.get(1) * Prize.FOURTH.getAmount()) +
        (winningCounts.get(2) * Prize.THIRD.getAmount()) +
        (winningCounts.get(3) * Prize.SECOND.getAmount()) +
        (winningCounts.get(4) * Prize.FIRST.getAmount());

    float yield = (float) totalPrize / purchaseAmount * 100;

    return Math.round(yield * 10) / 10.0f; // 소수점 둘째 자리에서 반올림
  }
}
