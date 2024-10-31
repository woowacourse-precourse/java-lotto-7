package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private int moneyInput;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        processInput();
        lottoService.checkLottoResult();
        outputView.printLottoResult(moneyInput);
    }

    private void processInput() {
        processMoneyInput();
        processWinnerNumbersInput();
        processBonusNumberInput();
    }

    private void processMoneyInput() {
        continueUntilNormalInput(() -> {
            outputView.printMoneyInputMessage();
            this.moneyInput = inputView.getMoneyInput();

            lottoService.purchaseLotto(moneyInput);
            lottoService.printPurchasedLottoNumbers();
        });
    }

    private void processWinnerNumbersInput() {
        continueUntilNormalInput(() -> {
            outputView.printWinnerNumbersInputMessage();
            List<Integer> winnerNumbersInput = inputView.getWinnerNumbersInput();

            lottoService.setWinnerLotto(winnerNumbersInput);
        });
    }

    private void processBonusNumberInput() {
        continueUntilNormalInput(() -> {
            outputView.printBonusNumberInputMessage();
            int bonusNumber = inputView.getBonusNumberInput();

            lottoService.setBonusNumber(bonusNumber);
        });
    }

    private void continueUntilNormalInput(Runnable processSpecificInput) {
        while (true) {
            try {
                processSpecificInput.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
