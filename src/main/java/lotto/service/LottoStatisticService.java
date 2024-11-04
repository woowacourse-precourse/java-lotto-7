package lotto.service;

import lotto.model.domain.LottoStatistic;
import lotto.model.vo.WinningNumber;

public interface LottoStatisticService {
    LottoStatistic calculateStatistic(WinningNumber winningNumber);
}
