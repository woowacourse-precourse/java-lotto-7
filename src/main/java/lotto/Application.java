package lotto;

import lotto.config.AppConfig;
import lotto.controller.ServerController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        ServerController serverController = appConfig.serverController();
        serverController.run();

    }
}
