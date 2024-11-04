package lotto.controller.lottoStaticsController;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public interface LottoStaticsController {

    void printLottoStatics(List<Lotto> purchasedLottos, WinningLotto winningLotto, Money money);
}
