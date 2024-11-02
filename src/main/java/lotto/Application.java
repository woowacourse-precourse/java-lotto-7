package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        final LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
