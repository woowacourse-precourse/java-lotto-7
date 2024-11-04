package lotto.config;

import lotto.controller.LottoController;
import lotto.handler.ExceptionHandler;
import lotto.model.service.LottServiceImpl;
import lotto.model.service.LottoService;
import lotto.view.inputview.InputView;
import lotto.view.outputview.ResultView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoService(), inputView(), resultView());
    }

    public LottoService lottoService() {
        return new LottServiceImpl();
    }

    public InputView inputView() {
        return new InputView(exceptionHandler());
    }

    public ResultView resultView() {
        return new ResultView();
    }

    public ExceptionHandler exceptionHandler() {
        return new ExceptionHandler();
    }
}
