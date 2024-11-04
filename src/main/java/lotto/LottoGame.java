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

        List<Lotto> lottos = lottoMachine.generateLottos(purchaseAmount);

        OutputHandler.printLottos(lottos);

        WinningLotto winningLotto = InputHandler.getWinningLotto();

        result.calculateResults(winningLotto, lottos);
        OutputHandler.printResults(result, purchaseAmount);
    }
}
