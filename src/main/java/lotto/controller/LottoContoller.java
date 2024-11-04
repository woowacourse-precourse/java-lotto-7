package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoContoller {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoContoller(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String purchaseAmount = inputView.inputPurchaseAmount();
        lottoService.purchaseLotto(purchaseAmount);

        outputView.printLottoLogs(lottoService.generateLottoLogs());

        String winningNumbersInput = inputView.inputWinningNumbers();
        String bonusNumberInput = inputView.inputBonusNumber();

        outputView.printWinningReport(lottoService.generateWinningReport(
                winningNumbersInput, bonusNumberInput
        ));

        double profitRate = lottoService.computeProfitRate(
                purchaseAmount,
                winningNumbersInput,
                bonusNumberInput
        );
        outputView.printProfitRate(profitRate);
    }
}
