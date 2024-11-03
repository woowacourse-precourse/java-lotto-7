package lotto.controller;

import lotto.factory.WinningGeneratorFactory;
import lotto.service.generator.WinningGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.message.PrintMessage;

public class WinningController {

    private final InputView inputView;
    private final OutputView outputView;

    public WinningController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public WinningGenerator inputWinning() {
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
            return WinningGeneratorFactory.create(lottoWinning);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
        }
        return null;
    }
}
