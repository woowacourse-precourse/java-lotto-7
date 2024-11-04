package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoSimulator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        LottoSimulator lottoSimulator = new LottoSimulator(appConfig.getLottoShop());
        lottoSimulator.start();
    }
}
