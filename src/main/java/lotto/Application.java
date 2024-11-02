package lotto;
import lotto.core.controller.GameController;
import lotto.core.controller.InputController;
import lotto.core.view.OutputView;


public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputController(),new OutputView());
        gameController.startGame();
        gameController.showResult();
//        try {
//            AppController.initialize().run();
//        } catch (InterruptedException e) {
//            throw new IllegalArgumentException(e);
//        }
    }
}
