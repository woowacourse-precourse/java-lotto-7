package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = inputView.getPurchaseAmount();
        lottoService.generateLottos(purchaseAmount);

        outputView.printLottos(lottoService.getLottos());
        lottoService.setWinningNumbers(inputView.getWinningNumbers(), inputView.getBonusNumber());

        outputView.printResults(lottoService.calculateResults());

        outputView.printProfitRate(lottoService.calculateProfitRate(purchaseAmount));
    }
}