package lotto.service.statistic.prize;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;

public interface PrizeCalculatorService {
    int calculateTotalPrize(Lottos lottos, WinningNumbers winningNumbers);
}
