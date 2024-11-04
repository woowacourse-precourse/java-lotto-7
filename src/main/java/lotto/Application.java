package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.util.InputValidator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new LottoService(new InputValidator()));
        lottoController.run();
    }
}
