package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.model.LottoCollection;

public class LottoService {
    private final PurchaseAmount purchaseAmount;
    private final LottoCollection lottoCollection;

    public LottoService(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        int numberOfLotto = this.purchaseAmount.getNumberOfLotto();
        this.lottoCollection = new LottoCollection(numberOfLotto);
    }
}
