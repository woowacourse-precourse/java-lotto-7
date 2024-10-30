package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private final LottoController lottoController;
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
        this.lottoController = new LottoController(lottoService, inputView, outputView);
    }

    public LottoController getLottoController(){
        return lottoController;
    }
}
