package lotto;

import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoStatisticsController;
import lotto.controller.LottoWinningNumbersController;

public class Application {


    public static void main(String[] args) {

        LottoApplication app = new LottoApplication(
            new LottoPurchaseController(),
            new LottoWinningNumbersController(),
            new LottoStatisticsController()
        );

        app.run();
    }
}
