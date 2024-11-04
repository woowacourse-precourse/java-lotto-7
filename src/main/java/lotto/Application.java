package lotto;

import lotto.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = MainController.getInstance();

        mainController.run();
    }
}
