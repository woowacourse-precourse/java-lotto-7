package lotto;

import lotto.common.config.MainConfig;
import lotto.common.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainConfig config = new MainConfig();
        MainController mainController = config.mainController();
        mainController.control();
    }
}
