package lotto.service;

import java.util.List;
import lotto.service.domain.lotto.Lotto;

public interface LottoValueProvider {
    List<Lotto> makePurchasedLotto(int money);
    void makeWinningStatistics();
}
