package lotto.config;

import lotto.controller.ErrorHandler;
import lotto.controller.InputHandler;
import lotto.controller.LottoController;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicketFactory;
import lotto.service.LottoEvaluator;
import lotto.service.LottoService;
import lotto.service.PrizeCalculator;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public InputView getInputView() {
        return new InputView();
    }

    public OutputView getOutputView() {
        return new OutputView();
    }

    public ErrorHandler getErrorHandler() {
        return new ErrorHandler(getOutputView());
    }

    public InputHandler getInputHandler() {
        return new InputHandler(getErrorHandler());
    }

    public LottoService getLottoService() {
        return new LottoService(getLottoShop(), getLottoEvaluator(), getPrizeCalculator());
    }

    public LottoEvaluator getLottoEvaluator() {
        return new LottoEvaluator();
    }

    public PrizeCalculator getPrizeCalculator() {
        return new PrizeCalculator();
    }

    public LottoShop getLottoShop() {
        return new LottoShop(getLottoTicketFactory());
    }

    public LottoTicketFactory getLottoTicketFactory() {
        return new LottoTicketFactory(getLottoNumberGenerator());
    }

    public LottoNumberGenerator getLottoNumberGenerator() {
        return new LottoNumberGenerator();
    }

    public LottoController getLottoController() {
        return new LottoController(getLottoService(), getInputView(), getOutputView(), getInputHandler());
    }
}
