package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();
        LottoService lottoService = new LottoService();
        InputController inputController = new InputController(inputView, inputValidator, outputView);
        LottoController lottoController = new LottoController(inputView, outputView, lottoService, inputController);
        lottoController.process();
    }
}
