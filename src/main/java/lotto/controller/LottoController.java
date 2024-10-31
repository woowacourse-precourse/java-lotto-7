package lotto.controller;

import lotto.domain.User;
import lotto.service.SystemService;
import lotto.service.numbers.LottoService;
import lotto.validator.exception.LottoException;
import lotto.view.input.InputView;
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
//        inputWinningNumbers();
//        inputBonusNumber();
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

//    private void inputWinningNumbers() {
//        while(true) {
//            try {
//                String winningNumbers = inputView.inputWinningNumbers();
//                lottoService.winningLotto(winningNumbers);
//                break;
//            } catch (LottoException e) {
//                outputView.displayErrorMessage(e);
//            }
//        }
//    }
//
//    private void inputBonusNumber() {
//        while(true) {
//            try {
//                String bonusNumber = inputView.inputBonusNumber();
//                lottoService.bonusNumber(bonusNumber);
//                break;
//            } catch (LottoException e) {
//                outputView.displayErrorMessage(e);
//            }
//        }
//    }
}
