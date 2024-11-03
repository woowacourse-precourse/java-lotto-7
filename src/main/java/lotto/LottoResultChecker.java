package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoResultChecker {
  private static HashMap<WinningRank, Integer> map = new HashMap<>();

  public void run(List<Lotto> lottoList, List<Integer> winnerNumber) {
    checkLottoAll(lottoList, winnerNumber);
    lottoResultMessage();
  }

  private void checkLottoAll(List<Lotto> lottoList, List<Integer> winningNumber) {
    for (int i = 0; i < lottoList.size(); i++) {
      WinningRank rank = compareThisLotto(lottoList.get(i), winningNumber);
      map.put(rank, map.getOrDefault(rank, 0) + 1);
    }
  }

  private WinningRank compareThisLotto(Lotto lotto, List<Integer> winningNumber) {
    List<Integer> mainNumber = winningNumber.subList(0, 6);
    int bonusNumber = winningNumber.get(6);
    long count = lotto.getNumbers()
        .stream()
        .filter(mainNumber::contains)
        .count();
    return rankSelect(count, lotto.getNumbers().contains(bonusNumber));
  }

  private WinningRank rankSelect(long count, boolean bonusOk) {
    if (count == 6) {
      return WinningRank.SIX_MATCH;
    }
    if (count == 5 && bonusOk) {
      return WinningRank.FIVE_MATCH_BONUS;
    }
    if (count == 5) {
      return WinningRank.FIVE_MATCH;
    }
    if (count == 4) {
      return WinningRank.FOUR_MATCH;
    }
    if (count == 3) {
      return WinningRank.THREE_MATCH;
    }
    return WinningRank.NO_LUCK;
  }

  private void lottoResultMessage() {
    //결과 출력
  }
}