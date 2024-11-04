package lotto.strategy;

import lotto.Lotto;

public interface LottoMatchCounter {
    int count(Lotto purchasedLottos,
              Lotto selectWinnerLotto,
              int bonusNumber);
}
