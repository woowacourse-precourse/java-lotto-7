package lotto.config;

import lotto.controller.LottoController;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.validator.NumberValidator;
import lotto.validator.PurchaseValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoService(), inputService(), outputView());
    }

    public InputService inputService() {
        return new InputService(inputView(), purchaseValidator(), numberValidator());
    }

    public LottoService lottoService() {
        return new LottoService();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public NumberValidator numberValidator() {
        return new NumberValidator();
    }

    public PurchaseValidator purchaseValidator() {
        return new PurchaseValidator();
    }
}
