package lotto.config;

import lotto.*;

public class ApplicationConfiguration {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public LottoProcessor lottoProcessor() {
        return new LottoProcessor();
    }
}
