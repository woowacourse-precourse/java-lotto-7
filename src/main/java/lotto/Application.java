package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new InputView(), new OutputView(), new LottoGenerator());
        controller.run();
    }
}
