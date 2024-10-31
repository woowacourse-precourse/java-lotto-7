package lotto.service;


import lotto.domain.LottoCount;

public class LottoService {

    public int getLottoCountByAmount(int purchaseAmount) {
        LottoCount lottoCount = new LottoCount(purchaseAmount);
        return lottoCount.getCount();
    }
}
