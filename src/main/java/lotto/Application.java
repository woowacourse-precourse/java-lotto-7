package lotto;

import lotto.controller.ApplicationController;
import lotto.view.ViewInput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationController controller = new ApplicationController(new ViewInput());
        controller.run();
    }
}
