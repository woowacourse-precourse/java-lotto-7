package lotto.config;

import lotto.controller.LottoCheckerController;

public final class LottoCheckerConfig {

    public static LottoCheckerController lottoCheckerController = getLottoStatisticController();

    private LottoCheckerConfig() {
    }

    private static LottoCheckerController getLottoStatisticController() {
        if (lottoCheckerController == null) {
            lottoCheckerController = new LottoCheckerController();
        }
        return lottoCheckerController;
    }
}
