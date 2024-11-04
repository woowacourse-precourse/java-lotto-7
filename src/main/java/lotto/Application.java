package lotto;

import lotto.config.AppConfig;
import lotto.controller.ApplicationController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        ApplicationController applicationController = appConfig.createAppRunner();
        applicationController.run();
    }
}