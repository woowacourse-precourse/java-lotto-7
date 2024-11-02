package lotto.controller;

import lotto.factory.WinningGeneratorFactory;
import lotto.service.WinningGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

public class WinningController {

    private final InputView inputView;
    private final OutputView outputView;
    private final WinningGenerator winningGenerator;

    public WinningController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winningGenerator = inputLottoWinning();
    }

    private WinningGenerator inputLottoWinning() {
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
        outputView.printlnMessage(PrintMessage.INPUT_LOTTO_WINNING_NUMBER);
        String lottoWinning = inputView.inputUser();

        return WinningGeneratorFactory.create(lottoWinning);
    }

    public WinningGenerator getWinningGenerator() {
        return winningGenerator;
    }
}
