package lotto;

import controller.LottoController;
import lotto.generator.RandomNumberGenerator;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        final LottoController lottoController = new LottoController(
                new LottoService(),
                new RandomNumberGenerator()
        );
        lottoController.startLottoGame();
    }
}
