package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoGame lottoGame = new LottoGame(
                appConfig.inputView(),
                appConfig.lottoManager(),
                appConfig.outputView()
        );
        lottoGame.start();
    }
}
