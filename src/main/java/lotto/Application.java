package lotto;

import lotto.config.LottoGameAppConfig;
import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameAppConfig config = new LottoGameAppConfig();
        LottoGameController lottoGame = config.lottoGame();

        lottoGame.start();
    }
}



