package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.exception.LottoException;
import lotto.service.SystemService;
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
        User user = purchaseLotto();
        Lotto winningLotto = inputWinningNumbers();
        WinningNumber winningNumber = inputBonusNumber(winningLotto);

        inputView.consoleClose();

        outputResult(user, winningNumber);
    }

    private User purchaseLotto() {
        while (true) {
            try {
                String purchaseAmount = inputView.inputPurchaseAmount();
                User user = systemService.generateUser(purchaseAmount);
                outputView.displayLottos(user);
                return user;
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }

    private Lotto inputWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                return systemService.generateLotto(winningNumbers);
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }

    private WinningNumber inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                return systemService.generateBonusNumber(bonusNumber, winningLotto);
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }

    private void outputResult(User user, WinningNumber winningNumber) {
        outputView.displayMessage(OutputMessage.WINNING_STATISTICS.getOutputMessage());
        outputView.displayMessage(OutputMessage.HYPHEN.getOutputMessage());
        outputView.displayStatistics(systemService.generateResult(user, winningNumber));
    }
}
