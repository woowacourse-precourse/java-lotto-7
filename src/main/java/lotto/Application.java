package lotto;

import lotto.controller.Controller;
import lotto.controller.ControllerImpl;

public class Application {
    public static void main(String[] args) {
        Controller controller = ControllerImpl.getInstance();
        controller.run();
    }
}
