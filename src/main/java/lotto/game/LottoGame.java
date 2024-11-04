package lotto.game;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

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
