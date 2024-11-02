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

import lotto.constant.Constant;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.model.LottoCollection;

public class LottoService {
    private final LottoCollection lottoCollection;
    private final WinningLotto winningLotto;

    public LottoService(LottoCollection lottoCollection, WinningLotto winningLotto) {
        this.lottoCollection = lottoCollection;
        this.winningLotto = winningLotto;
    }

    public void judgeLotto() {
        lottoCollection.compareWinningLotto(winningLotto);
    }

    public int [] getWinningResult() {
       return lottoCollection.getWinningResult();
    }

    public double getRateOfReturn() {
        int totalWinnings = lottoCollection.getTotalWinnings();
        double purchaseAmount1 = lottoCollection.getPurchaseAmount();
        double result = totalWinnings / purchaseAmount1;
        return result * Constant.PERCENTAGE;
    }
}
