package lotto.service.prize;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;

public interface TotalPrizeCalculatorService {
    int calculateTotalPrize(Lottos lottos, WinningNumbers winningNumbers, WinningStatistic winningStatistic);
}
