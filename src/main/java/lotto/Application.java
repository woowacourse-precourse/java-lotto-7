package lotto;

import lotto.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        new LottoApp(config.lottoController()).run();
    }
}
