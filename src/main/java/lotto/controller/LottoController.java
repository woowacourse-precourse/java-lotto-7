package lotto.controller;

import lotto.service.SystemService;
import lotto.validator.exception.LottoException;
import lotto.view.input.InputView;
import lotto.view.output.OutputMessage;
import lotto.view.output.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final SystemService systemService;

    public LottoController(InputView inputView, OutputView outputView, SystemService systemService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.systemService = systemService;
    }

    public void startLottoSimulation() {
        purchaseLotto();
        inputWinningNumbers();
        inputBonusNumber();
        outputWinningStatistics();
    }

    private void purchaseLotto() {
        while (true) {
            try {
                String purchaseAmount = inputView.inputPurchaseAmount();
                outputView.displayLottos(systemService.userProcess(purchaseAmount));
                break;
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }

    private void inputWinningNumbers() {
        while(true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                systemService.winningLottoProcess(winningNumbers);
                break;
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }

    private void inputBonusNumber() {
        while(true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                systemService.bonusNumberProcess(bonusNumber);
                break;
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }
    private void outputWinningStatistics() {
        outputView.displayMessage(OutputMessage.WINNING_STATISTICS.getOutputMessage());
        outputView.displayMessage(OutputMessage.HYPHEN.getOutputMessage());
        outputView.displayStatistics(systemService.statisticsProcess());
    }
}
