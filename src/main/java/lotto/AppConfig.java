package lotto;

import lotto.presentation.controller.BonusNumberController;
import lotto.presentation.controller.PurchaseController;
import lotto.presentation.controller.StatisticsController;
import lotto.presentation.controller.WinningNumbersController;
import lotto.presentation.controller.common.FrontController;
import lotto.service.NumbersSelector;
import lotto.service.RandomNumbersSelector;
import lotto.service.purchase.PurchaseService;
import lotto.service.purchase.PurchaseServiceImpl;
import lotto.service.winning.WinningService;
import lotto.service.winning.WinningServiceImpl;

public class AppConfig {
    
    private static final AppConfig INSTANCE = new AppConfig();
    
    private static final NumbersSelector numbersSelector = new RandomNumbersSelector();

    private static final PurchaseService purchaseService = new PurchaseServiceImpl(numbersSelector);
    private static final WinningService winningService = new WinningServiceImpl();

    private static final PurchaseController purchaseController
        = new PurchaseController(purchaseService);
    private static final WinningNumbersController winningNumbersController
        = new WinningNumbersController();
    private static final BonusNumberController bonusNumberController
        = new BonusNumberController(winningService);
    private static final StatisticsController statisticsController
        = new StatisticsController(winningService);

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public NumbersSelector numbersSelector() {
        return numbersSelector;
    }

    public PurchaseService purchaseService() {
        return purchaseService;
    }

    public WinningService winningService() {
        return winningService;
    }

    public PurchaseController purchaseController() {
        return purchaseController;
    }

    public WinningNumbersController winningNumbersController() {
        return winningNumbersController;
    }

    public BonusNumberController bonusNumberController() {
        return bonusNumberController;
    }

    public StatisticsController statisticsController() {
        return statisticsController;
    }

    public FrontController frontController() {
        return FrontController.getInstance();
    }
}
