/*
 * 클래스 이름 LottoService
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
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

    public void judgeLotto() {
        lottoCollection.compareWinningLotto(winningLotto);
    }

    public int [] getWinningResult() {
       return lottoCollection.getWinningResult();
    }
}
