package lotto;

import lotto.controller.LotteryController;
import lotto.service.LotteryService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LotteryService lotteryService = new LotteryService();
        LotteryController controller = new LotteryController(lotteryService);
        controller.start();
    }
}
