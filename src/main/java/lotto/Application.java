package lotto;

import java.util.Random;
import lotto.common.RandomNumberGenerator;
import lotto.presentation.LottoController;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoService lottoService = new LottoService(randomNumberGenerator);
        LottoController lottoController = new LottoController(inputView, outputView, lottoService);

        lottoController.run();
    }
}
