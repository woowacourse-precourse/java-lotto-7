package lotto;

import lotto.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        new AppConfig().lottoController().run();
    }
}
