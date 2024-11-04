package lotto.Controller;

import lotto.Domain.LottoMachine;
import lotto.Domain.LottoNumber;
import lotto.View.InputView;
import lotto.View.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoGameController gameController = new LottoGameController(inputView, outputView);
        gameController.play();
    }
}

