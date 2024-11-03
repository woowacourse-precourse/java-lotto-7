package lotto;

import lotto.controller.LottoMachine;
import lotto.utils.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoMachine lottoMachine = appConfig.lottoMachine();
        lottoMachine.start();
    }
}
