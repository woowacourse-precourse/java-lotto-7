package lotto;

import controller.LottoController;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new ResultView());
        lottoController.start();
    }
}
