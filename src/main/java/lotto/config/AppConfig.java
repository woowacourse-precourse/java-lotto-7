package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.service.LottoService;
import lotto.service.impl.LottoServiceImpl;
import lotto.view.OutputView;
import lotto.view.impl.ConsoleOutputView;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();

    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoController lottoController;
    private final LottoMachine lottoMachine;

    private AppConfig() {
        this.outputView = new ConsoleOutputView();
        this.lottoMachine = new LottoMachine();
        this.lottoService = new LottoServiceImpl(this.lottoMachine);
        this.lottoController = new LottoController(this.lottoService, this.outputView);
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public LottoService getLottoService() {
        return lottoService;
    }

    public LottoController getLottoController() {
        return lottoController;
    }

    public LottoMachine getLottoMachine() {
        return lottoMachine;
    }
}
