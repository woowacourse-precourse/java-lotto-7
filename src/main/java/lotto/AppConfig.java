package lotto;

import lotto.lottery.controller.LottoController;
import lotto.lottery.infrastructure.LottoRandomHolder;
import lotto.lottery.service.LottoService;
import lotto.lottery.service.port.RandomHolder;
import lotto.winningNumber.service.MatchService;
import lotto.winningNumber.service.WinningNumberService;

public class AppConfig {
    public LottoController lottoController() {
        return new LottoController(lottoService(), winningNumberService(), matchService());
    }

    public RandomHolder randomHolder() {
        return new LottoRandomHolder();
    }

    public LottoService lottoService() {
        return new LottoService(randomHolder());
    }

    public WinningNumberService winningNumberService() {
        return new WinningNumberService();
    }

    public MatchService matchService() {
        return new MatchService();
    }
}
