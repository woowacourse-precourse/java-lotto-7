package lotto;

import lotto.Config.GameControllerConfig;
import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameControllerConfig config = GameControllerConfig.getInstance();
        GameController gameController = config.getGameController();

        gameController.run();
    }
}
