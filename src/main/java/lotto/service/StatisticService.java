package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import lotto.model.WinningNumbers;

import java.util.List;

public class StatisticService {
    public LottoStatistics calculateStatistics(List<Lotto> lottos, WinningNumbers winningNumbers) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.calculateStatistics(lottos, winningNumbers);
        return lottoStatistics;
    }

    public double calculateProfit(LottoStatistics lottoStatistics, int purchaseAmount) {
        return lottoStatistics.calculateProfit(purchaseAmount);
    }
}
