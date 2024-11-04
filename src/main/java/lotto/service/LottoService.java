package lotto.service;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.vo.Money;

public interface LottoService {
    List<Lotto> buyLotto(Money money);
}
