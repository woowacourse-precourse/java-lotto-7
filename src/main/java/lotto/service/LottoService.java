package lotto.service;

import lotto.domain.LottoGroups;
import lotto.domain.LottoMachine;
import lotto.domain.LottoSeller;
import lotto.domain.Money;

public class LottoService {

    public LottoGroups purchaseLottos(Money lottoPurchaseMoney) {
        LottoSeller lottoSeller = new LottoSeller(new LottoMachine());
        return lottoSeller.sellUntilNoMoney(lottoPurchaseMoney);
    }
}
