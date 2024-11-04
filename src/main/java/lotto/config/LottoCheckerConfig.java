package lotto.config;

import lotto.controller.LottoCheckerController;

public final class LottoCheckerConfig {

    public static LottoCheckerController lottoCheckerController = getLottoCheckerController();

    private LottoCheckerConfig() {
    }

    static LottoCheckerController getLottoCheckerController() {
        if (lottoCheckerController == null) {
            lottoCheckerController = new LottoCheckerController();
        }
        return lottoCheckerController;
    }
}
