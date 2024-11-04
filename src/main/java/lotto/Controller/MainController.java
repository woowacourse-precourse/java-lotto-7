package lotto.Controller;

import lotto.View.InputView;
import lotto.View.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameController gameController;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameController = new LottoGameController(inputView, outputView);
    }

    public void run() {
        gameController.play();
    }
}