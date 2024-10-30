package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        int moneyInput = processInput();
        lottoService.checkLottoResult();
        outputView.printLottoResult(moneyInput);
    }

    private int processInput() {
        int moneyInput = getMoneyInput();
        lottoService.purchaseLotto(moneyInput);
        lottoService.printPurchasedLottoNumbers();

        List<Integer> winnerNumbersInput = getWinnerNumbers();
        lottoService.setWinnerLotto(winnerNumbersInput);

        int bonusNumber = getBonusNumber();
        lottoService.setBonusNumber(bonusNumber);

        return moneyInput;
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
