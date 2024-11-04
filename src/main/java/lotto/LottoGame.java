package lotto;

import java.util.List;

public class LottoGame {
    private LottoMachine lottoMachine;
    private Result result;

    public LottoGame() {
        lottoMachine = new LottoMachine();
        result = new Result();
    }

    public void play() {
        PurchaseAmount purchaseAmount = InputHandler.getPurchaseAmount();

        int purchaseCount = purchaseAmount.getPurchaseCount();

        List<Lotto> lottos = lottoMachine.generateLotto(purchaseCount);
        
        OutputHandler.printLottos(lottos);

        WinningLotto winningLotto = InputHandler.getWinningLotto();

        result.calculateResults(winningLotto, lottos);

        OutputHandler.printResults(result, purchaseAmount);
    }
}
