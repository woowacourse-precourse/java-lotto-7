package lotto.controller;

import java.util.List;
import lotto.handler.LottoInputHandler;
import lotto.handler.ResultHandler;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoService lottoService;
    private final LottoInputHandler inputHandler;
    private final ResultHandler resultHandler;
    private final OutputView outputView;

    public LottoGameController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputHandler = new LottoInputHandler(inputView, outputView);
        this.resultHandler = new ResultHandler(lottoService, outputView);
        this.outputView = outputView;
    }

    public void run() {
        try {
            int purchaseAmount = handlePurchaseAmount();
            handleLottoGeneration(purchaseAmount);
            handleWinningNumbersInput();
            handleResults(purchaseAmount);
        } finally {
            inputHandler.close();
        }
    }

    private int handlePurchaseAmount() {
        return inputHandler.getPurchaseAmount();
    }

    private void handleLottoGeneration(int purchaseAmount) {
        lottoService.generateLottoTickets(purchaseAmount);
        outputView.printLottoPurchase(lottoService.getPurchasedTickets());
    }

    private void handleWinningNumbersInput() {
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber(winningNumbers);
        lottoService.setWinningNumbers(winningNumbers, bonusNumber);
    }

    private void handleResults(int purchaseAmount) {
        resultHandler.calculateResults();
        resultHandler.printWinningResults();
        resultHandler.printProfitRate(purchaseAmount);
    }

}
