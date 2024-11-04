package lotto;

import lotto.presentation.controller.BonusNumberController;
import lotto.presentation.controller.PurchaseController;
import lotto.presentation.controller.StatisticsController;
import lotto.presentation.controller.WinningNumbersController;
import lotto.presentation.controller.common.FrontController;
import lotto.presentation.model.Model;

public class Application {

    private static final AppConfig appConfig = AppConfig.getInstance();
    private static final FrontController controller = appConfig.frontController();
    private static final PurchaseController purchaseController = appConfig.purchaseController();
    private static final WinningNumbersController winningNumbersController = appConfig.winningNumbersController();
    private static final BonusNumberController bonusNumberController = appConfig.bonusNumberController();
    private static final StatisticsController statisticsController = appConfig.statisticsController();

    public static void main(String[] args) {
        Model model = new Model();

        controller.process(purchaseController, model);
        controller.process(winningNumbersController, model);
        controller.process(bonusNumberController, model);
        controller.process(statisticsController, model);
    }
}
