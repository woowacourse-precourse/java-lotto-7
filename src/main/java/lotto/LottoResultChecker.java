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
    System.out.println("당첨 통계\n---");
    WinningRank[] rankList = WinningRank.values();
    for (WinningRank rank : rankList) {
      Integer count = map.get(rank);
      if (count == null) {
        count = 0;
      }
      if (rank != WinningRank.NO_LUCK) {
        System.out.printf(rank.getDescription() + " - %d개\n", count);
      }
    }
  }
}