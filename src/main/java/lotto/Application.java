package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;

public class Application {
    public static void main(String[] args) {
        GameService service = new GameService();
        GameController controller = new GameController(service);
        controller.run();
    }
}
