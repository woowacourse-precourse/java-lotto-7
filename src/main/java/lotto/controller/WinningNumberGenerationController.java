package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningNumberGenerator;
import lotto.util.IoComponent;

import static lotto.util.common.RepeatInput.repeatUntilValid;

public class WinningNumberGenerationController {
    private final WinningNumberGenerator winningNumberGenerator;
    private final IoComponent ioComponent;

    public WinningNumberGenerationController(WinningNumberGenerator winningNumberGenerator, IoComponent ioComponent) {
        this.ioComponent = ioComponent;
        this.winningNumberGenerator = winningNumberGenerator;
    }

    public Lotto createWinningNumber() {
        ioComponent.getInputView().printRequestWinningNumbers();
        return repeatUntilValid(this::requestWinningNumber,ioComponent.getCommonIo());
    }

    private Lotto requestWinningNumber(){
            String rawWinningNumbers = ioComponent.getIoController().inputWinningNumbers();
            return winningNumberGenerator.createWinningNumbers(rawWinningNumbers);
    }

}
