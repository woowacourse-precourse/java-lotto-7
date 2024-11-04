package lotto.service.winningStatistic;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;

public interface WinningStatisticService {
    WinningStatistic calculateWinningStatistic(int cost, Lottos lottos, WinningNumbers winningNumbers);
}
