package lotto.service;

import java.util.List;
import lotto.model.Lotto;

public interface LottoGenerator {
    void setMoney(long money);

    List<Lotto> getLottos();

    Lotto getLotto();
}
