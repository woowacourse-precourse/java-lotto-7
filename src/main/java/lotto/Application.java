package lotto;

import lotto.controller.LottoController;
import lotto.util.InputValidator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputValidator());
        lottoController.run();
    }
}
