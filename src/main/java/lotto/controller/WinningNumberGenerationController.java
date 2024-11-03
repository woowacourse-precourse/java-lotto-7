package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningNumberGenerator;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;

import static lotto.util.RepeatInput.repeatUntilValid;

public class WinningNumberGenerationController {
    private final WinningNumberGenerator winningNumberGenerator;
    private final InputView inputView;
    private final IoController ioController;
    private final CommonIo commonIo = new CommonIo();

    public WinningNumberGenerationController(WinningNumberGenerator winningNumberGenerator) {
        this.inputView = new InputView(commonIo);
        this.ioController = new IoController(commonIo);
        this.winningNumberGenerator = winningNumberGenerator;
    }

    public Lotto createWinningNumber() {
        inputView.printRequestWinningNumbers();
        return repeatUntilValid(() -> {
            String rawWinningNumbers = ioController.inputWinningNumbers();
            return winningNumberGenerator.createWinningNumbers(rawWinningNumbers);
        },commonIo);
    }

}
