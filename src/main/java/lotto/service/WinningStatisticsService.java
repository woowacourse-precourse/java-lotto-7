package lotto.service;

import lotto.domain.buyer.Buyer;
import lotto.domain.winning.LottoMatcher;
import lotto.domain.winning.WinningInfo;
import lotto.domain.winning.WinningStatistics;

public class WinningStatisticsService {
    public WinningStatistics calculateWinningStatistics(Buyer buyer, WinningInfo winningInfo) {
        LottoMatcher lottoMatcher = new LottoMatcher();
        WinningStatistics winningStatistics = WinningStatistics.of(lottoMatcher, buyer);
        winningStatistics.calculateWinningStatistics(buyer, winningInfo);
        return winningStatistics;
    }
}
