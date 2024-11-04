package lotto.back;

import lotto.back.global.support.ApplicationContext;
import lotto.back.global.support.FrontController;

public class BackApplication {

    public static void run() {
        ApplicationContext.init();

        FrontController.run();
    }
}
