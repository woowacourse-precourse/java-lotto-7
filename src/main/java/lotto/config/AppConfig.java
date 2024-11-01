package lotto.config;

import lotto.controller.LottoController;
import lotto.service.SystemService;
import lotto.service.numbers.LottoNumberService;
import lotto.service.result.ResultService;
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
        return new SystemService(lottoNumberService(), resultService(), userService());
    }

    private UserService userService() {
        return new UserService();
    }

    private LottoNumberService lottoNumberService() {
        return new LottoNumberService();
    }

    private ResultService resultService() {
        return new ResultService();
    }

}
