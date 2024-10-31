package lotto;

import lotto.controller.LottoController;
import lotto.generator.LottoGenerator;
import lotto.generator.RandomLottoGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = RandomLottoGenerator.getInstance();
        LottoService lottoService = new LottoService(lottoGenerator);

        LottoController lottoController = new LottoController(outputView, inputView, lottoService);
        lottoController.run();
    }
}
