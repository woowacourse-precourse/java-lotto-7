package lotto;

import lotto.controller.LottoController;
import lotto.domain.DefaultLottoGenerator;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResultCalculator;
import lotto.service.LottoService;
import lotto.util.validator.InputValidator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new DefaultLottoGenerator();
        LottoResultCalculator calculator = new LottoResultCalculator();
        InputValidator inputValidator = new InputValidator();

        LottoService lottoService = new LottoService(lottoGenerator, calculator);

        LottoController lottoController = new LottoController(lottoService, inputValidator);

        lottoController.startLottoGame();
    }
}
