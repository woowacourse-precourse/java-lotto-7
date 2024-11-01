package lotto.service;

import java.util.List;
import java.util.Set;
import lotto.service.domain.lotto.Lotto;

public interface LottoValueProvider {
    Set<Lotto> makePurchasedLotto(int money);
    void makeWinningStatistics();
}
