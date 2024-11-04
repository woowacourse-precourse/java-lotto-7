package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        appConfig.lottoGameController().run();
        Console.close();
    }
}
