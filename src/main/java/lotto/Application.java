package lotto;

import lotto.config.AppConfig;
import lotto.config.AppRunner;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        AppRunner appRunner = appConfig.createAppRunner();
        appRunner.run();
    }
}