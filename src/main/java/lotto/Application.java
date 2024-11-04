package lotto;

import lotto.application.LottoService;
import lotto.presentation.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService());
        lottoController.run();
    }
}
