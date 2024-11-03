package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoControllerFactory {

    public static LottoController getLottoController() {
        return new LottoController(InputView.getInstance(), OutputView.getInstance(), new LottoService());
    }
}
