package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore store;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.store = new LottoStore();
    }

    public void run(){
        int purchaseAmount = inputView.RequestPurchaseAmount();
        Lottos lottos = purchaseLotto(purchaseAmount);
        WinningResult winningResult = createWinningResult();
        printResults(lottos, winningResult);
    }

    private Lottos purchaseLotto(int purchaseAmount) {
        Lottos lottos = store.sell(purchaseAmount);
        outputView.printPurchaseResult(lottos);
        return lottos;
    }

    private WinningResult createWinningResult() {
            try {
                Lotto winningLotto = new Lotto(inputView.RequestWinningNumbers());
                int bonusNumber = inputView.RequestBonusNumber();
                return new WinningResult(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return createWinningResult();
            }
    }

    private void printResults(Lottos lottos, WinningResult winningResult) {
        Map<Prize, Integer> prizeResult = winningResult.calculateResult(lottos);
        outputView.printWinningStatistics(prizeResult);
        outputView.printReturnRate(winningResult.calculateReturnRate(lottos));
    }
}
