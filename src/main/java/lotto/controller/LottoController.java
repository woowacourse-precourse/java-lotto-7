package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void paly(){
        outputView.printRequest(OutputView.REQUEST_AMOUNT_MESSAGE);
        String amount= inputView.readInput();
    }
}
