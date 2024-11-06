package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.SimpleInputValidator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(new SimpleInputValidator()),
                new OutputView());
        lottoController.play();
    }
}
