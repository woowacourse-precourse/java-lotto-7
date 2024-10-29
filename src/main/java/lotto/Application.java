package lotto;

import lotto.lottery.controller.LottoController;
import lotto.util.Validator;
import lotto.view.InputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
