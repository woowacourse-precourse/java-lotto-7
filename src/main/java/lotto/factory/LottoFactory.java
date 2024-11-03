package lotto.factory;

import lotto.controller.LottoController;
import lotto.domain.LottoResult;
import lotto.service.WinningService;

public class LottoFactory {

    private LottoFactory(){
    }

    public static WinningService WinningServiceCreate() {
        return new WinningService(LottoResult.create());
    }

    public static LottoController createLottoController() {
        return new LottoController(WinningServiceCreate());
    }
}
