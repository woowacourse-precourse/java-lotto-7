package lotto;

import lotto.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        LottoApp lottoApp = new LottoApp(
            config.lottoGenerateController(),
            config.lottoCheckController(),
            config.lottoResultController());

        lottoApp.run();
    }
}
