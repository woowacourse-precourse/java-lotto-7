package lotto.config;

import lotto.Service.LottoService;
import lotto.controller.LottoController;
import lotto.validator.InputValidator;

public class AppConfig {
    private static final InputValidator inputValidator = new InputValidator();
    private static final LottoService lottoService = new LottoService(inputValidator);

    public static LottoController createLottoController(){
        return new LottoController(lottoService);
    }
}
