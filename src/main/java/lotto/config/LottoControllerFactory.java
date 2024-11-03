package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.generator.RandomTicketNumberGenerator;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchasePriceValidator;
import lotto.validator.WinningNumbersValidator;

public class LottoControllerFactory {
    public static LottoController create() {
        return new LottoController(
                new PurchasePriceValidator(),
                new WinningNumbersValidator(),
                new BonusNumberValidator(),
                new LottoService(new RandomTicketNumberGenerator())
        );
    }
}
