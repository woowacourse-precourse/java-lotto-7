package lotto.controller;

import lotto.model.LottoMachine;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        String purchaseAmount = inputView.readPurchaseAmount();
        lottoMachine.initMachine();
    }
}
