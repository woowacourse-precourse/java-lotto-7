package lotto;

import lotto.common.config.LottoConfig;
import lotto.interfaces.lotto.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoConfig lottoConfig = new LottoConfig();
        LottoController lottoController = lottoConfig.provideLottoController();
        lottoController.lottoGameStart();
    }
}
