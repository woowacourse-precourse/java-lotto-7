package lotto.controller;

import lotto.service.generator.WinningGenerator;
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
        this.winningGenerator = inputWinning();
    }

    private WinningGenerator inputWinning() {
        while (true) {
            WinningGenerator newWinningGenerator = inputLottoWinning();
            outputView.printlnMessage(PrintMessage.LINE_SPACE);
            if (newWinningGenerator != null) {
                return newWinningGenerator;
            }
        }
    }

    private WinningGenerator inputLottoWinning() {
        try {
            outputView.printlnMessage(PrintMessage.INPUT_LOTTO_WINNING_NUMBER);
            String lottoWinning = inputView.inputUser();
            return WinningGenerator.create(lottoWinning);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
        }
        return null;
    }

    public WinningGenerator getWinningGenerator() {
        return winningGenerator;
    }
}
