package lotto;

import lotto.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getAppConfig();
        LottoMachine lottoMachine = new LottoMachine(appConfig);

        lottoMachine.run();
    }
}
