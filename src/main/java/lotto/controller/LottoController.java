package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.OutputView;

public class LottoController {
    private final InputController inputController;
    private final LottoService lottoService;
    private final OutputView outputView;

    private int purchasePrice;
    private List<Integer> winningNumbers;
    private int bonusNumber;


    public LottoController() {
        this.inputController = new InputController();
        setInputs();

        this.lottoService = new LottoServiceImpl(winningNumbers, bonusNumber);
        this.outputView = new OutputView(lottoService);

        printLottos();
        printWinningResults();
    }

    private void setInputs() {
        purchasePrice = inputController.setPurchasePrice();
        winningNumbers = inputController.setWinningNumbers();
        bonusNumber = inputController.setBonusNumber();
    }

    private void printLottos() {
        outputView.lottoCount(purchasePrice);
        outputView.printLottos(purchasePrice);
    }

    private void printWinningResults() {
        outputView.printWinningResults(purchasePrice);
    }
}
