package lotto.application;

import lotto.MakeNumbersStrategy;
import lotto.Reader;

public class LottoApplication {

    private final MakeNumbersStrategy makeNumbersStrategy;
    private final Reader reader;

    public LottoApplication(AppConfig appConfig) {
        this.makeNumbersStrategy = appConfig.makeNumbersStrategy();
        this.reader = appConfig.reader();
    }
}
