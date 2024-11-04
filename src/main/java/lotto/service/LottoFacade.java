package lotto.service;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;

public interface LottoFacade {
    Lottos issueLottos(int purchaseAmount);

    WinningStatistic getStatistic(int cost, Lottos lottos, WinningNumbers winningNumbers);
}
