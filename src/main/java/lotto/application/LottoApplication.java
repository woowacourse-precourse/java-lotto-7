package lotto.application;

import lotto.config.AppConfig;

public class LottoApplication {

    private final MakeNumbersStrategy makeNumbersStrategy;
    private final Reader reader;

    public LottoApplication(AppConfig appConfig) {
        this.makeNumbersStrategy = appConfig.makeNumbersStrategy();
        this.reader = appConfig.reader();
    }

    public void run() {
        String price = reader.read();
    }
}
