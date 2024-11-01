package lotto;

import lotto.controller.LottoController;
import lotto.model.InputService;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputService(),
                new InputView(),
                new OutputView(),
                new LottoResult()
        );
        lottoController.run();
    }
}
