package lotto.controller;

import java.util.Map;
import lotto.enums.Prize;
import lotto.model.LottoResultChecker;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore store;

    public LottoController() {
        this.store = new LottoStore();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String purchaseAmount = inputView.getLottoPurchaseAmount();
        Lottos lottos = store.purchaseLottos(purchaseAmount);
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(inputView.getWinningNumbers(), inputView.getBonusNumber());

        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningNumbers);
        Map<Prize, Integer> winningResult = lottoResultChecker.getLottosWinningResult(lottos);
        double yield = lottoResultChecker.getYield(winningResult, lottos);
        outputView.printResults(winningResult, yield);
    }
}
