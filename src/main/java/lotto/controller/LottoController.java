package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.NumberParser;
import lotto.view.util.WinningNumberSplitter;

import java.util.List;
import java.util.function.Supplier;

public class LottoController {
    private final NumberParser numberParser;
    private final WinningNumberSplitter winningNumberSplitter;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(NumberParser numberParser, WinningNumberSplitter winningNumberSplitter, InputView inputView, OutputView outputView) {
        this.numberParser = numberParser;
        this.winningNumberSplitter = winningNumberSplitter;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Integer purchaseAmount = getPurchaseAmount();
        List<Integer> winningNumber = getWinningNumber();
    }

    public Integer getPurchaseAmount() {
        return getValidatedInput(inputView::readPurchaseAmount);
    }

    public List<Integer> getWinningNumber() {
        try {
            String input = inputView.readWinningNumber();
            List<String> winningNumber = winningNumberSplitter.splitWinningNumber(input);
            return winningNumber.stream()
                    .map(numberParser::parseToInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getWinningNumber();
        }
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
