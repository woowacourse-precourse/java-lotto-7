package lotto.service;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;


public class GameService {
    private LottoMachine lottoMachine;
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public GameService() {
        this.lottoMachine = new LottoMachine();
    }

    public LottoTicket purchaseLotto(int money) {
        lottoTicket = lottoMachine.purchaseTicket(money);
        lottoResult = new LottoResult(money);
        return lottoTicket;
    }


    public LottoResult resultLotto(Lotto winLotto, Bonus bonusNumber) {
        winningLotto = new WinningLotto(winLotto, bonusNumber);
        for (Lotto lotto : lottoTicket.getLottos()) {
            lottoResult.recordResult(winningLotto, lotto);
        }
        return  lottoResult;
    }
}
