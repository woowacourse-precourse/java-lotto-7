package lotto.service;

import lotto.domain.Bonus;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import lotto.model.LottoCollection;

public class LottoService {
    private PurchaseAmount purchaseAmount;
    private LottoCollection lottoCollection;
    private WinningLotto winningLotto;

    public LottoService() {
        purchaseAmount = null;
        lottoCollection = null;
    }

    public void readPurchaseAmount(String readLine) {
        this.purchaseAmount = new PurchaseAmount(readLine);
    }

    public String getLottoPurchaseResult() {
        return this.lottoCollection.getState();
    }

    public void lottoIssuance() {
        int numberOfLotto = this.purchaseAmount.getNumberOfLotto();
        this.lottoCollection = new LottoCollection(numberOfLotto);
    }

    public void readWinningLotto(WinningNumber winningNumber, Bonus bonus) {
        this.winningLotto = new WinningLotto(winningNumber, bonus);
    }
}
