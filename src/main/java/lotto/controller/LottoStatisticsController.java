package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MatchStatistics;
import lotto.domain.WinningNumber;

class LottoStatisticsController {
    public void calculateMatches(List<Lotto> lottoNumbers, WinningNumber winningNumber,
                                 MatchStatistics matchStatistics) {
        matchStatistics.calculateMatches(lottoNumbers, winningNumber);
    }
}