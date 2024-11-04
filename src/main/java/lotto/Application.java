package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new InputView(), new OutputView(),
                new LottoGenerator());
        lottoGameController.run();
    }
}
