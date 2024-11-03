package lotto.controller;

import lotto.model.Lotto;
import lotto.temp.IoController;
import lotto.temp.Winning;
import lotto.util.CommonIo;
import lotto.view.InputView;

public class WinningController {
    private final Winning winning;
    private final InputView inputView;
    private final IoController ioController;

    public WinningController(Winning winning) {
        CommonIo commonIo = new CommonIo();
        this.inputView = new InputView(commonIo);
        this.ioController = new IoController(commonIo);
        this.winning = winning;
    }

    public Lotto createWinningNumber(){
        inputView.printRequestWinningNumbers();
        String rawWinningNumbers = ioController.inputWinningNumbers();
        return winning.createWinningNumbers(rawWinningNumbers);
    }
}
