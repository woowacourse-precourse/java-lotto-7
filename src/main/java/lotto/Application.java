package lotto;
import lotto.core.controller.GameController;


public class Application {

    public static void main(String[] args) {
        GameController.getInstance().run();
    }
}
