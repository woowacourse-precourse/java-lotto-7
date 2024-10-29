package lotto;

import lotto.controller.LottoController;
import lotto.util.Validator;
import lotto.view.InputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler(new Validator());
        LottoController lottoController = new LottoController(inputHandler);

        lottoController.run();
    }
}
