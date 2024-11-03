package lotto;

import lotto.controller.LottoController;
import lotto.generator.LottoGenerator;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.InputViewImpl;
import lotto.ui.ResultView;
import lotto.ui.ResultViewImpl;
import lotto.validation.Validator;
import lotto.validation.ValidatorImpl;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputViewImpl();
        ResultView resultView = new ResultViewImpl();
        Validator validator = new ValidatorImpl();
        LottoService lottoService = new LottoService(new LottoGenerator());

        LottoController lottoController = new LottoController(inputView, resultView, validator, lottoService);
        lottoController.executeLottoPurchase();
    }
}
