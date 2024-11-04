package lotto;

import lotto.controller.LottoController;
import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = createLottoController();
        lottoController.start();
    }

    private static LottoController createLottoController() {
        return new LottoController(
                new InputView(),
                new OutputView(),
                new RandomLottoNumberGenerator()
        );
    }

}
