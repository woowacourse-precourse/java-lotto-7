package lotto.config;

import lotto.service.LottoService;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameAppConfig {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final LottoService lottoService = new LottoService();
    private static final LottoController lottoController = new LottoController(lottoService,inputView,outputView);


    private LottoGameAppConfig() {
    }

    public static LottoController getLottoController() {
        return lottoController;
    }
}
