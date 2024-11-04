package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningNumber;

public class LottoEvaluator {

  public Result evaluateLottoTickets(List<Lotto> lottos, WinningNumber winningNumber,
      BonusNumber bonusNumber) {
    Result result = new Result();

    for (Lotto lotto : lottos) {
      int matchCount = lotto.countMatchingNumbers(winningNumber.getNumbers());
      boolean matchBonus = lotto.containsNumber(bonusNumber.getNumber());
      Rank rank = Rank.valueOf(matchCount, matchBonus);
      result.addRank(rank);
    }

    return result;
  }
}
