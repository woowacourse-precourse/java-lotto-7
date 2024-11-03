package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.service.LottoService;
import lotto.service.SetupService;

public class LottoController {
    private final SetupService setupService;
    private final LottoService lottoService;

    private LottoController() {
        setupService = SetupService.getInstance();
        lottoService = LottoService.getInstance();
    }

    private static class SingletonHelper {
        private static final LottoController INSTANCE = new LottoController();
    }

    public static LottoController getInstance() {
        return LottoController.SingletonHelper.INSTANCE;
    }


    public Lottos purchaseLottos(int purchaseAmount) {
        return setupService.purchaseLottos(purchaseAmount);
    }

    public Result winningResult(Lottos lottos, Lotto targetLotto, int bonusNumber) {
        return lottoService.winningResult(lottos, targetLotto, bonusNumber);
    }
}
