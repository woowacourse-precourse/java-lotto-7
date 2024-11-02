package lotto;
import lotto.core.controller.GameController;
import lotto.core.controller.InputController;
import lotto.core.view.OutputView;


public class Application {

    public static void main(String[] args) {
        try {
            GameController.initialize(new InputController(),new OutputView()).run();
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
