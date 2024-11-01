package lotto.controller;

import lotto.model.LottoMachine;
import lotto.util.Parser;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoMachine lottoMachine;
    private final Parser parser;

    public LottoController(InputView inputView, LottoMachine lottoMachine, Parser parser) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
        this.parser = parser;
    }

    public void run() {
        int purchaseAmount = parser.purchaseAmountParser(inputView.readPurchaseAmount());
        lottoMachine.initMachine();
        lottoMachine.issueLottos(purchaseAmount);
    }
}
