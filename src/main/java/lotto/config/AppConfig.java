package lotto.config;

import lotto.application.validation.AmountValidator;
import lotto.application.validation.BaseValidation;
import lotto.presentation.controller.LottoController;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;


public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), amountValidator());
    }

    public InputView inputView() {
        return new InputView();
    }
    public OutputView outputView() {
        return new OutputView();
    }
    public BaseValidation<Integer> amountValidator() {
        return new AmountValidator();
    }
}
