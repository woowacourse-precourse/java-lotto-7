package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new ConsoleView());
        lottoController.run();
    }
}
