package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.User;
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
        User user = purchaseLotto();
        Lotto winningLotto = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber(winningLotto);
        outputResult(user, winningLotto, bonusNumber);
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

    private BonusNumber inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                return systemService.generateBonusNumber(bonusNumber, winningLotto);
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }

    private void outputResult(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        outputView.displayMessage(OutputMessage.WINNING_STATISTICS.getOutputMessage());
        outputView.displayMessage(OutputMessage.HYPHEN.getOutputMessage());
        outputView.displayStatistics(systemService.generateResult(user, winningLotto, bonusNumber));
    }
}
