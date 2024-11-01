package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoManager;
import lotto.domain.LottoResultFormatter;
import lotto.service.LottoService;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView(), new LottoService(new LottoGenerator(new LottoValidator()), new LottoManager(), new LottoResultFormatter()));
        lottoController.run();
    }
}
