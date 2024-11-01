package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.NumberParser;

import java.util.function.Supplier;

public class LottoController {
    private final NumberParser numberParser;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(NumberParser numberParser, InputView inputView, OutputView outputView) {
        this.numberParser = numberParser;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Integer purchaseAmount = getPurchaseAmount();
        Integer winningNumber = getWinningNumber();
    }

    public Integer getPurchaseAmount() {
        return getValidatedInput(inputView::readPurchaseAmount);
    }

    public Integer getWinningNumber() {
        return getValidatedInput(inputView::readWinningNumber);
    }

    private Integer getValidatedInput(Supplier<String> inputReader) {
        try {
            String input = inputReader.get();
            return numberParser.parseToInt(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getValidatedInput(inputReader);
        }
    }
}
