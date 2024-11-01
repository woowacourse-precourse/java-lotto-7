package lotto.service;

import lotto.model.LottoResult;
import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;

public class LottoService {

    public LottoTicket createLottoTicket(String purchaseMoney) {
        return LottoStore.makeLottoTicket(purchaseMoney);
    }

    public WinningLotto createWinningLotto(String winningNumber) {
        return WinningLotto.create(winningNumber);
    }

    public void addBonusNumber(WinningLotto winningLotto, String bonusNumber) {
        winningLotto.addBonusNumber(bonusNumber);
    }

    public LottoResult compareLotto(LottoTicket lottoTicket, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.compare(lottoTicket, winningLotto);
        return lottoResult;
    }
}
