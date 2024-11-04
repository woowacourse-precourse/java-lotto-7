package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController game = new LottoController(new InputView(),new OutputView());
        game.run();
    }
}
