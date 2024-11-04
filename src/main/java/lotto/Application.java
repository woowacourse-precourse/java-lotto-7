package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = ConsoleView.getInstance();
        LottoController lottoController = new LottoController(consoleView);

        lottoController.run();

    }
}
