package lotto.config;

import lotto.io.*;
import lotto.io.impl.*;
import lotto.validator.LottoInputValidator;

public class LottoConfig {

    private static LottoConfig config;

    private LottoConfig() {

    }

    public static LottoConfig getInstance() {
        if(config == null)
            config = new LottoConfig();

        return config;
    }

    public Output output() {
        return ConsoleOutput.getInstance();
    }

    public Input input() {
        return ConsoleInput.getInstance(output());
    }

    public LottoInputValidator lottoInputValidator() {
        return LottoInputValidator.getInstance(output());
    }
}
