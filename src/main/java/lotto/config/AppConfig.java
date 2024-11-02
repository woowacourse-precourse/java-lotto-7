package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import lotto.service.InMemoryLottoService;
import lotto.service.LottoService;
import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(inputView(), lottoService());
    }

    public InputView inputView() {
        return new InputView();
    }

    public LottoRepository lottoRepository() {
        return InMemoryLottoRepository.getInstance();
    }

    public LottoValidator lottoValidator() {
        return new LottoValidator();
    }

    public LottoService lottoService() {
        return InMemoryLottoService.getInstance(lottoValidator(), lottoRepository());
    }
}
