package lotto;

import lotto.controller.LottoController;
import lotto.view.console.ConsoleInputView;
import lotto.view.console.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final ConsoleInputView consoleInputView = new ConsoleInputView();
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        final LottoController lottoController = new LottoController(consoleInputView, consoleOutputView);
        lottoController.run();
    }
}
