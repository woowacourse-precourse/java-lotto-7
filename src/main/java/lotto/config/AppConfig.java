package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.EarningRateCalculator;
import lotto.domain.LottoStore;
import lotto.domain.lottomachine.AutoNumberGenerator;
import lotto.domain.lottomachine.LottoMachine;
import lotto.service.LottoService;
import lotto.view.InputProcessor;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.NumberParser;
import lotto.view.util.WinningNumberSplitter;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(
                lottoService(),
                inputProcessor(),
                new OutputView()
        );
    }

    private LottoService lottoService() {
        return new LottoService(
                lottoMachine(),
                new LottoStore(),
                new EarningRateCalculator()
        );
    }

    private LottoMachine lottoMachine() {
        return new LottoMachine(new AutoNumberGenerator());
    }

    private InputProcessor inputProcessor() {
        return new InputProcessor(
                new NumberParser(),
                new WinningNumberSplitter(),
                new InputView()
        );
    }
}
