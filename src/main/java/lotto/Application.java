package lotto;

import lotto.controller.LottoController;
import lotto.view.Input.InputView;
import lotto.view.Output.OutputView;
import lotto.service.LottoService;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.RandomLottoGenerator;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoGenerator();
        LottoService lottoService = new LottoService(lottoNumberGenerator);

        LottoController lottoController = new LottoController(inputView, outputView, lottoService);
        lottoController.run();
    }
}
