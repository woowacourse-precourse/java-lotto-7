package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInputValidator;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new LottoView(new LottoInputValidator()));
        controller.run();
    }
}
