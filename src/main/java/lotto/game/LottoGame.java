package lotto.game;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoGame {
    private LottoMachine lottoMachine;
    private LottoResult lottoResult;

    public LottoGame() {
        lottoMachine = new LottoMachine();
        lottoResult = new LottoResult();
    }

    public void play() {
        PurchaseAmount purchaseAmount = InputHandler.getPurchaseAmount();

        List<Lotto> lottos = lottoMachine.generateLottos(purchaseAmount);

        OutputHandler.printLottos(lottos);

        WinningLotto winningLotto = InputHandler.getWinningLotto();

        lottoResult.updateRankCounts(winningLotto, lottos);
        OutputHandler.printResults(lottoResult, purchaseAmount);
    }
}
