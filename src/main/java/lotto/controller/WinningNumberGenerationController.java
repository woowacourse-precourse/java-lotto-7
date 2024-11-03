package lotto.controller;

import lotto.model.Lotto;
import lotto.temp.IoController;
import lotto.model.WinningNumberGenerator;
import lotto.util.CommonIo;
import lotto.view.InputView;

public class WinningNumberGenerationController {
    private final WinningNumberGenerator winningNumberGenerator;
    private final InputView inputView;
    private final IoController ioController;

    public WinningNumberGenerationController(WinningNumberGenerator winningNumberGenerator) {
        CommonIo commonIo = new CommonIo();
        this.inputView = new InputView(commonIo);
        this.ioController = new IoController(commonIo);
        this.winningNumberGenerator = winningNumberGenerator;
    }

    public Lotto createWinningNumber(){
        inputView.printRequestWinningNumbers();
        String rawWinningNumbers = ioController.inputWinningNumbers();
        return winningNumberGenerator.createWinningNumbers(rawWinningNumbers);
    }
}
