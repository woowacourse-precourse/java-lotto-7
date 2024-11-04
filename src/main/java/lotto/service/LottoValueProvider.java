package lotto.service;

import java.util.List;
import java.util.Set;
import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.statistics.StatisticsReport;

public interface LottoValueProvider {
    List<Lotto> makePurchasedLotto(int money);
    StatisticsReport makeWinningStatistics(List<Integer> winningNumber, int bonusNumber);
}
