package lotto;

import lotto.controller.LottoController;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.prompt.impl.ConsolePrompt;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new ConsolePrompt());
        OutputView outputView = new OutputView();
        new LottoController(inputView, outputView).run();
    }

}
