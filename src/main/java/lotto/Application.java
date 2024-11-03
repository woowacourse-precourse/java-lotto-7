package lotto;

import lotto.adapters.input.LottoCliInputAdapter;
import lotto.infrastructure.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        LottoCliInputAdapter lottoCliInputAdapter = appConfig.getLottoCliInputAdapter();
        lottoCliInputAdapter.run();
    }
}
