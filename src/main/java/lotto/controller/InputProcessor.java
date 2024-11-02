package lotto.controller;

import lotto.controller.util.NumberParser;
import lotto.controller.util.WinningNumberSplitter;
import lotto.domain.Lotto;
import lotto.view.InputView;

import java.util.List;

public class InputProcessor {

    private final NumberParser numberParser;
    private final WinningNumberSplitter winningNumberSplitter;
    private final InputView inputView;

    public InputProcessor(NumberParser numberParser, WinningNumberSplitter winningNumberSplitter, InputView inputView) {
        this.numberParser = numberParser;
        this.winningNumberSplitter = winningNumberSplitter;
        this.inputView = inputView;
    }

    public Integer processPurchaseLottos() {
        String input = inputView.readPurchaseAmount();
        return numberParser.parseToInt(input);
    }

    public Lotto processWinningNumber() {
        String input = inputView.readWinningNumber();
        List<String> winningNumber = winningNumberSplitter.splitWinningNumber(input);
        return new Lotto(winningNumber.stream()
                .map(numberParser::parseToInt)
                .toList());
    }

    public Integer processBonusNumber() {
        String input = inputView.readBonusNumber();
        return numberParser.parseToInt(input);
    }
}
