package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInputValidator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(
                new LottoInputView(new LottoInputValidator()),
                new LottoOutputView()
        );
        controller.run();
    }
}
