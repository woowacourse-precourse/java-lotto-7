package lotto.service.user;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.utils.LottoGenerator;
import lotto.utils.PurchaseCalculator;

public class LottoService {

    public Lottos generateUserLottos(Money userMoney) {
        int lottoCount = PurchaseCalculator.calculateLottoCount(userMoney);
        return LottoGenerator.generateLottos(lottoCount);
    }
}
