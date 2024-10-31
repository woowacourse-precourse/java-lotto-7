package lotto.config;

import lotto.controller.LottoController;
import lotto.service.SystemService;
import lotto.service.numbers.BonusNumberService;
import lotto.service.result.ProfitService;
import lotto.service.result.ResultService;
import lotto.service.result.StatisticService;
import lotto.service.user.LottoGeneratorService;
import lotto.service.numbers.LottoService;
import lotto.service.user.MoneyService;
import lotto.service.numbers.WinningLottoService;
import lotto.service.user.UserService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), systemService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
    private SystemService systemService() {
        return new SystemService(lottoService(), resultService(), userService());
    }

    private UserService userService() {
        return new UserService(moneyService(), lottoGeneratorService());
    }
    private MoneyService moneyService() {
        return new MoneyService();
    }
    private LottoGeneratorService lottoGeneratorService() {
        return new LottoGeneratorService();
    }
    private LottoService lottoService() {
        return new LottoService(winningLottoService(), bonusNumberService());
    }
    private BonusNumberService bonusNumberService() {
        return new BonusNumberService();
    }

    private WinningLottoService winningLottoService() {
        return new WinningLottoService();
    }
    private ResultService resultService() {
        return new ResultService(statisticService(), profitService());
    }
    private ProfitService profitService() {
        return new ProfitService();
    }
    private StatisticService statisticService() {
        return new StatisticService();
    }

}
