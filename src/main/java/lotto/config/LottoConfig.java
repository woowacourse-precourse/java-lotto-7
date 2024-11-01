package lotto.config;

import lotto.io.*;
import lotto.io.impl.*;
import lotto.service.*;

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

    public LottoService lottoService() {
        return LottoService.getInstance(config);
    }
}
