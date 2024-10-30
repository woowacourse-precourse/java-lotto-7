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
        while (true) {
            try {
                this.moneyInput = getMoneyInput();
                lottoService.purchaseLotto(moneyInput);
                lottoService.printPurchasedLottoNumbers();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                continue;
            }
        }
    }

    private void processWinnerNumbersInput() {
        while (true) {
            try {
                List<Integer> winnerNumbersInput = getWinnerNumbers();
                lottoService.setWinnerLotto(winnerNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                continue;
            }
        }
    }

    private void processBonusNumberInput() {
        while (true) {
            try {
                int bonusNumber = getBonusNumber();
                lottoService.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                continue;
            }
        }
    }

    private int getMoneyInput() {
        outputView.printMoneyInputMessage();
        return inputView.getMoneyInput();
    }

    private List<Integer> getWinnerNumbers() {
        outputView.printWinnerNumbersInputMessage();
        return inputView.getWinnerNumbersInput();
    }

    private int getBonusNumber() {
        outputView.printBonusNumberInputMessage();
        return inputView.getBonusNumberInput();
    }
}
