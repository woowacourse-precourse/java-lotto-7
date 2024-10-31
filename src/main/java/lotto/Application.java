package lotto;

import lotto.controller.LottoController;
import lotto.io.ConsoleReader;
import lotto.io.view.View;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(ConsoleReader.getInstance(), View.getInstance());
        lottoController.run();
    }
}
