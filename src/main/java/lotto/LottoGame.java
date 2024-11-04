package lotto;

import lotto.config.LottoConfig;
import lotto.controller.LottoController;

public class LottoGame {

    private final LottoController lottoController;

    public LottoGame() {
        LottoConfig lottoConfig = new LottoConfig();
        this.lottoController = lottoConfig.lottoController();
    }

    public void run() {
        lottoController.run();
    }
}
