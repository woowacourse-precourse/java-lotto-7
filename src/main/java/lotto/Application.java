package lotto;

import lotto.controller.LotteryController;

public class Application {
    public static void main(String[] args) {
        LotteryController controller = new LotteryController();
        controller.run();
    }
}
