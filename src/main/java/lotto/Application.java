package lotto;

import lotto.common.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        config.getLottoController().run();
    }
}
