package lotto;

import lotto.controller.LottoController;
import lotto.domain.InputConverter;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchasedLotto;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(
                new InputConverter(),
                new LottoGenerator(),
                new PurchasedLotto()
        );

        controller.run();
    }
}
