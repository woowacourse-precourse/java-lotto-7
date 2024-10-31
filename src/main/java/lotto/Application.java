package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoValidator lottoValidator = new LottoValidator();

        LottoController lottoController = new LottoController(lottoService, inputView, outputView, lottoValidator);

        lottoController.startLottoProcess();
    }
}
