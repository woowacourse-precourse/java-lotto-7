package lotto.controller;

import lotto.service.LottoService;
import lotto.util.InputValidator;
import lotto.view.InputView;

public class LottoControllerFactory {
    private LottoControllerFactory() {};

    public static LottoController createLottoController() {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        LottoService lottoService = new LottoService();
        return new LottoController(inputView, lottoService);
    }
}
