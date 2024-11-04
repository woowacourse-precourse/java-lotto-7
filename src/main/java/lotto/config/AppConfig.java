package lotto.config;

import lotto.controller.Controller;
import lotto.service.LottoNumberService;
import lotto.service.LottoService;
import lotto.service.WinningStatisticsService;
import lotto.view.InputHandler;
import lotto.view.InputView;

public class AppConfig {
    public Controller controller() {
        return new Controller(inputView(), lottoService(), lottoNumberService(),
                winningStatisticsService());
    }

    public InputHandler inputHandler() {
        return new InputHandler();
    }

    public InputView inputView() {
        return new InputView();
    }

    public LottoService lottoService() {
        return new LottoService(inputHandler());
    }

    public LottoNumberService lottoNumberService() {
        return new LottoNumberService(inputHandler());
    }

    public WinningStatisticsService winningStatisticsService() {
        return new WinningStatisticsService();
    }
}
