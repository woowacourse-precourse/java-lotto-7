package lotto.controller;

import lotto.domain.LottoGroups;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final LottoService lottoService;
    private final InputController inputController;

    public LottoController(OutputView outputView,
                           LottoService lottoService,
                           InputController inputController) {
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.inputController = inputController;
    }

    public void process() {
        Money lottoPurchaseMoney = inputController.inputLottoPurchaseMoney();
        LottoGroups lottoGroups = lottoService.purchaseLottos(lottoPurchaseMoney);
        outputView.printPurchaseLottos(lottoGroups.getLottos());

        WinningLotto winningLotto = inputController.inputWinningLotto();
        LottoResult lottoResult = lottoGroups.calculateLottoResult(winningLotto, lottoPurchaseMoney);
        outputView.printLottoResults(lottoResult);
    }
}
