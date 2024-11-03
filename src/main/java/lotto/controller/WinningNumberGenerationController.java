package lotto.controller;

import lotto.model.Lotto;
import lotto.temp.IoController;
import lotto.model.WinningNumberGenerator;
import lotto.util.CommonIo;
import lotto.view.InputView;

import java.util.function.Supplier;

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

    public Lotto createWinningNumber(){
        inputView.printRequestWinningNumbers();
        String rawWinningNumbers = repeatUntilValid(ioController::inputWinningNumbers);
        return winningNumberGenerator.createWinningNumbers(rawWinningNumbers);
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException illegalArgumentException) {
            commonIo.printMessage(illegalArgumentException.getMessage());
            return repeatUntilValid(function);
        }
    }
}
