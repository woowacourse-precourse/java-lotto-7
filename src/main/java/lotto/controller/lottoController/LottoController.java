package lotto.controller.lottoController;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public interface LottoController {

    List<Lotto> purchaseLottos(Money money);
}
