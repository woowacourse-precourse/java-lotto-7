package lotto.handler;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.util.Parser;
import lotto.view.InputView;

import java.util.List;

public class WinningNumberOperation implements Operation<WinningNumber> {
    private final InputView inputView;
    private final Parser parser;

    public WinningNumberOperation(InputView inputView, Parser parser) {
        this.inputView = inputView;
        this.parser = parser;
    }

    @Override
    public WinningNumber execute() throws IllegalArgumentException {
        String rawWinningNumber = inputView.insertLetter();
        List<Integer> winningNumber = parser.ParseWinningNumber(rawWinningNumber);
        return new WinningNumber(new Lotto(winningNumber));
    }
}
