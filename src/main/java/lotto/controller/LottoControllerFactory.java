package lotto.controller;

import lotto.util.InputValidator;
import lotto.view.InputView;

public class LottoControllerFactory {
    private LottoControllerFactory() {};

    public static LottoController createLottoController() {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        return new LottoController(inputView);
    }
}
