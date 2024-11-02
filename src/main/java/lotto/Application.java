package lotto;

import lotto.utils.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoMachine lottoMachine = appConfig.lottoMachine();
        lottoMachine.run();
    }
}
