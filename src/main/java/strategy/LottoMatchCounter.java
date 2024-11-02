package strategy;

import domain.lotto.Lotto;

public interface LottoMatchCounter {
    int count(Lotto purchasedLottos,
              Lotto selectWinnerLotto,
              int bonusNumber);
}
