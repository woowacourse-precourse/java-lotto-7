package lotto;

import lotto.common.config.LottoConfig;

public class Application {
    public static void main(String[] args) {
        LottoConfig config = new LottoConfig();
        config.getLottoController().run();
    }
}
