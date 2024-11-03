package lotto.service;

import java.util.List;
import lotto.model.Lottos;
import lotto.model.WinningStatistic;

public interface LottoFacade {
    Lottos issueLottos(int purchaseAmount);

    WinningStatistic getStatistic(int purchaseAmount, int cost, List<Integer> winningNumbers, int bonusNumber,
                                  Lottos lottos);
}
