package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.constants.LottoPrize;
import lotto.constants.LottoConstants;
public class LottoService implements LottosServiceInterface {

  @Override
  public int getNumOfLottos(int purchaseAmount) {
    return purchaseAmount / LottoConstants.LOTTO_PRICE;
  }

  @Override
  public List<Lotto> generateLottosByAmount(int numOfLottos) {
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < numOfLottos; i++) {
      lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER, LottoConstants.NUMBER_COUNT)));
    }
    return lottos;
  }


  @Override
  public List<Integer> checkWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers,
      int bonusNumber) {
    List<Integer> winningCounts = Arrays.asList(0, 0, 0, 0, 0);

    for (Lotto lotto : lottos) {
      long matchCount = lotto.getNumbers().stream()
          .filter(winningNumbers::contains)
          .count();

      if (matchCount == LottoPrize.FIFTH.getMatchCount()) {
        winningCounts.set(0, winningCounts.get(0) + 1);
      } else if (matchCount == LottoPrize.FOURTH.getMatchCount()) {
        winningCounts.set(1, winningCounts.get(1) + 1);
      } else if (matchCount == LottoPrize.THIRD.getMatchCount()) {
        if (lotto.getNumbers().contains(bonusNumber)) {
          winningCounts.set(3, winningCounts.get(3) + 1);
        } else {
          winningCounts.set(2, winningCounts.get(2) + 1);
        }
      } else if (matchCount == LottoPrize.FIRST.getMatchCount()) {
        winningCounts.set(4, winningCounts.get(4) + 1);
      }
    }
    return winningCounts;
  }

  @Override
  public double calculateYield(List<Integer> winningCounts, int purchaseAmount) {

    int totalPrize = (winningCounts.get(0) * LottoPrize.FIFTH.getPrizeAmount()) +
        (winningCounts.get(1) * LottoPrize.FOURTH.getPrizeAmount()) +
        (winningCounts.get(2) * LottoPrize.THIRD.getPrizeAmount()) +
        (winningCounts.get(3) * LottoPrize.SECOND.getPrizeAmount()) +
        (winningCounts.get(4) * LottoPrize.FIRST.getPrizeAmount());

    double yield = (double) totalPrize / purchaseAmount * 100;

    return Math.round(yield * 10) / 10.0; // 소수점 둘째 자리에서 반올림
  }
}
