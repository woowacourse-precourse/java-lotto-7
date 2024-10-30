package lotto.Controller;

import lotto.View.InputView;
import lotto.View.OutputView;

public class MainController {
    private static final InputView inputView;
    private static final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
