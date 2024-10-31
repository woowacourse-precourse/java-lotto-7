package lotto.config;

import lotto.io.*;
import lotto.io.impl.*;

public class LottoConfig {

    private LottoConfig() {

    }

    public static LottoConfig getInstance() {
        return new LottoConfig();
    }

    public Output output() {
        return new ConsoleOutput();
    }

    public Input input() {
        return new ConsoleInput(output());
    }


}
