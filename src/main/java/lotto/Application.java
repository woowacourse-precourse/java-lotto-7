package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        Controller controller = new Controller();
        controller.run();
    }
}
