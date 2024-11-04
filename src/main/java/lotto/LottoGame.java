package lotto;

import java.util.List;

public class LottoGame {
    private LottoMachine lottoMachine;

    public LottoGame() {
        lottoMachine = new LottoMachine();
    }

    public void play() {
        PurchaseAmount purchaseAmount = InputHandler.getPurchaseAmount();

        int purchaseCount = purchaseAmount.getPurchaseCount();

        List<Lotto> lottos = lottoMachine.generateLotto(purchaseCount);

        WinningLotto winningLotto = InputHandler.getWinningLotto();
    }
}
