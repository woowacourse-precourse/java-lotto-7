package lotto.config;

import lotto.service.LottoService;
import lotto.service.PrizeCalculator;
import lotto.controller.LottoController;
import lotto.validator.InputValidator;

public class AppConfig {
    private static final InputValidator inputValidator = new InputValidator();
    private static final PrizeCalculator prizeCalculator = new PrizeCalculator();
    private static final LottoService lottoService = new LottoService(inputValidator);

    public static LottoController createLottoController(){
        return new LottoController(lottoService, prizeCalculator);
    }
}
