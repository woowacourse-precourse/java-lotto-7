package lotto.factory;

import lotto.controller.LottoController;
import lotto.domain.LottoResult;
import lotto.service.LottoService;

public class LottoFactory {

    private LottoFactory() {
    }

    public static LottoService WinningServiceCreate() {
        return new LottoService(LottoResult.create());
    }

    public static LottoController createLottoController() {
        return new LottoController(WinningServiceCreate());
    }
}
