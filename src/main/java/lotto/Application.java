package lotto;

import lotto.controller.ControllerBroker;

public class Application {
    public static void main(String[] args) {
        ControllerBroker.getInstance()
                .run();
    }
}
