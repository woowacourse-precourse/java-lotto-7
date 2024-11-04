package lotto;

import lotto.controller.ApplicationController;
import lotto.model.Lotto;
import lotto.view.ViewInput;
import lotto.view.ViewOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationController controller = new ApplicationController(new ViewInput(), new ViewOutput(), new Lotto());
        controller.run();
    }
}
