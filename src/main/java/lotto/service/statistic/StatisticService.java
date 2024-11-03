package lotto.service.statistic;

import java.util.List;
import lotto.model.Lottos;
import lotto.model.WinningStatistic;

public interface StatisticService {
    WinningStatistic getStatistic(int purchaseAmount, int cost, List<Integer> winningNumbers, int bonusNumber,
                                  Lottos lottos);
}
