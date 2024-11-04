package lotto;

import lotto.controller.LottoController;
import lotto.model.service.LottoGenerator;
import lotto.model.service.LottoService;
import lotto.view.input.InputParser;
import lotto.view.input.InputValidator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(new InputParser(",", new InputValidator()), outputView);
        LottoService lottoService = new LottoService(new LottoGenerator());
        LottoController lottoController = new LottoController(inputView, outputView, lottoService);

        lottoController.run();

    }
}
