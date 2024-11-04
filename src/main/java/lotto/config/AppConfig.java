package lotto.config;

import lotto.application.service.LottoService;
import lotto.application.validation.*;
import lotto.domain.generator.LottoNumberGeneratorImpl;
import lotto.infrastructure.repository.LottoRepositoryImpl;
import lotto.presentation.controller.LottoController;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;

import java.util.List;


public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), amountValidator(), lottoService(), lottoNumberValidator(), bonusNumberValidator());
    }

    public LottoService lottoService() {
        return new LottoService(new LottoNumberGeneratorImpl(), LottoRepositoryImpl());
    }

    public LottoRepositoryImpl LottoRepositoryImpl() {
        return new LottoRepositoryImpl();
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

    public BaseValidation<List<Integer>> lottoNumberValidator() {
        return new LottoNumberValidator();
    }

    public BonusNumberValidation bonusNumberValidator() {
        return new BonusNumberValidator();
    }
}
