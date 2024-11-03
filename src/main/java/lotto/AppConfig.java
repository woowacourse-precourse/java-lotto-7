package lotto;

import lotto.global.io.InputHandler;
import lotto.lottery.controller.LottoController;
import lotto.lottery.infrastructure.LottoRandomHolder;
import lotto.lottery.service.LottoService;
import lotto.lottery.service.port.RandomHolder;
import lotto.winningNumber.service.MatchService;
import lotto.winningNumber.service.WinningNumberService;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoService(), winningNumberService(),
                matchService(), inputTemplate());
    }

    public LottoService lottoService() {
        return new LottoService(randomHolder());
    }

    public RandomHolder randomHolder() {
        return new LottoRandomHolder();
    }

    public WinningNumberService winningNumberService() {
        return new WinningNumberService();
    }

    public MatchService matchService() {
        return new MatchService();
    }

    public InputHandler inputTemplate() {
        return new InputHandler();
    }

}
