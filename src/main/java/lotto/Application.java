package lotto;

import lotto.controller.LottoSystemController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoSystemController lottoSystemController = new LottoSystemController(inputView, outputView);

        lottoSystemController.run();
    }
}
