package lotto;

import lotto.controller.LottoController;
import lotto.io.Input;
import lotto.io.Output;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new Input(), new Output(), new LottoService());
        lottoController.run();
    }
}
