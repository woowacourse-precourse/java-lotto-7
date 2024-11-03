package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoContoller {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;

    private LottoContoller(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private static class Holder {
        private static final LottoContoller INSTANCE = new LottoContoller(
                LottoServiceImpl.getInstance(),
                InputView.getInstance(),
                OutputView.getInstance()
        );
    }

    public static LottoContoller getInstance() {
        return Holder.INSTANCE;
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
