package lotto.controller;

import lotto.domain.User;
import lotto.service.LottoService;
import lotto.validator.exception.LottoException;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void startLottoSimulation() {
        purchaseLotto();
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void purchaseLotto() {
        while (true) {
            try {
                String purchaseAmount = inputView.inputPurchaseAmount();
                User user = lottoService.purchaseLotto(purchaseAmount);
                outputView.displayLottos(user);
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
                lottoService.winningLotto(winningNumbers);
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
                lottoService.bonusNumber(bonusNumber);
                break;
            } catch (LottoException e) {
                outputView.displayErrorMessage(e);
            }
        }
    }
}
