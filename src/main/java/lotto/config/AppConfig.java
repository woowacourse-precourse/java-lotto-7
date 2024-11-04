package lotto.config;

import lotto.service.LottoCalculator;
import lotto.factory.WinningLottoFactory;
import lotto.view.InputView;
import lotto.factory.LottoFactory;
import lotto.view.OutputView;
import lotto.generator.RandomNumberGenerator;
import lotto.controller.LottoController;
import lotto.service.LottoService;

public class AppConfig {
    public LottoController createLottoController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new LottoController(inputView, outputView, createLottoService());
    }

    private LottoService createLottoService() {
        LottoFactory lottoFactory = new LottoFactory(new RandomNumberGenerator());
        WinningLottoFactory winningLottoFactory = new WinningLottoFactory();
        LottoCalculator lottoResultFactory = new LottoCalculator();
        return new LottoService(lottoFactory, winningLottoFactory, lottoResultFactory);
    }
}
