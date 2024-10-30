package lotto.controller;

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
        int moneyInput = getMoneyInput();
        lottoService.purchaseLotto(moneyInput);

    }

    private int getMoneyInput() {
        outputView.printMoneyInputMessage();
        return inputView.getMoneyInput();
    }
}
