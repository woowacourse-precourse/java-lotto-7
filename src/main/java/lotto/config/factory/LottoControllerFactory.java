package lotto.config.factory;

import lotto.controller.LottoController;
import lotto.generator.SortedLottoNumberGenerator;
import lotto.service.LottoService;

public class LottoControllerFactory {

    public static LottoController create() {
        return new LottoController(lotoLottoService());
    }

    private static LottoService lotoLottoService() {
        return new LottoService(sortedLottoNumberGenerator());
    }

    private static SortedLottoNumberGenerator sortedLottoNumberGenerator() {
        return new SortedLottoNumberGenerator();
    }
}
