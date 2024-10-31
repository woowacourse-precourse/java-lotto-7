package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.NumberParser;

public class LottoController {
    private final NumberParser numberParser;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(NumberParser numberParser, InputView inputView, OutputView outputView) {
        this.numberParser = numberParser;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Integer getPurchaseAmount() {
        try {
            String input = inputView.readPurchaseAmount();
            return numberParser.parseToInt(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
