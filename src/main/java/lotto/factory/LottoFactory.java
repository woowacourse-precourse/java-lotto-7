package lotto.factory;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {
    public static LottoController createLottoController() {
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new LottoController(lottoService, inputView, outputView);
    }
}
