package lotto;

import lotto.controller.ExceptionHandler;
import lotto.controller.LottoController;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.prompt.impl.ConsolePrompt;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new ConsolePrompt());
        OutputView outputView = new OutputView();
        ExceptionHandler exceptionHandler = new ExceptionHandler(outputView);
        new LottoController(inputView, outputView, exceptionHandler).run();
    }

}
