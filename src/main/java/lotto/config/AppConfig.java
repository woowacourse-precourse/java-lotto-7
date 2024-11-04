package lotto.config;

import lotto.controller.LottoController;
import lotto.model.service.LottoCreationService;
import lotto.model.service.LottoRateService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController(inputView(),lottoView(),lottoService(), lottoRateService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView lottoView() {
        return new OutputView();
    }

    private LottoCreationService lottoService() {
        return new LottoCreationService();
    }

    private LottoRateService lottoRateService(){return new LottoRateService();}
}
