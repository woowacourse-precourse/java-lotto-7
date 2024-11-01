package lotto.purchase.domain;

import lotto.lotto.domain.LottoResults;

public class Purchase {

    private final LottoResults lottoResults;
    private final Money money;

    public Purchase(LottoResults lottoResults, Money money) {
        this.lottoResults = lottoResults;
        this.money = money;
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }

    public Money getMoney() {
        return money;
    }
}
