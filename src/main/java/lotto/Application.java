package lotto;

import controller.LottoController;
import lotto.generator.RandomNumberGenerator;
import lotto.service.LottoService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        final LottoController lottoController = new LottoController(
                new InputView(),
                new OutputView(),
                new LottoService(),
                new RandomNumberGenerator()
        );
        lottoController.startLottoGame();
    }
}
