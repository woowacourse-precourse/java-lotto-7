package lotto.service.winningCheck;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;

public interface WinningCheckService {
    int checkPrize(Lotto lotto, WinningNumbers winningNumbers, WinningStatistic winningStatistic);

}
