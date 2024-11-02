package lotto.controller;

import lotto.Factory.WinningGeneratorFactory;
import lotto.service.WinningGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

public class WinningController {

    private final InputView inputView;
    private final OutputView outputView;

    public WinningController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void inputLottoWinning() {
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
        outputView.printlnMessage(PrintMessage.INPUT_LOTTO_WINNING_NUMBER);
        String lottoWinning = inputView.inputUser();

        WinningGenerator winningGenerator = WinningGeneratorFactory.create(lottoWinning);
        System.out.println(winningGenerator.getWinning().getNumbers().toString());
    }
}
