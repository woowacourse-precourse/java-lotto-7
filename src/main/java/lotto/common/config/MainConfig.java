package lotto.common.config;

import lotto.common.controller.MainController;
import lotto.common.controller.formatter.StringFormatter;
import lotto.common.controller.handler.ConsoleInputHandler;
import lotto.common.controller.handler.ConsoleOutputHandler;
import lotto.common.controller.provider.ConsoleInputProvider;
import lotto.common.controller.provider.InputProvider;
import lotto.lotto.config.LottoConfig;
import lotto.purchase.config.PurchaseConfig;

public class MainConfig {

    private final LottoConfig lottoConfig;
    private final PurchaseConfig purchaseConfig;

    public MainConfig() {
        lottoConfig = LottoConfig.getInstance();
        purchaseConfig = PurchaseConfig.getInstance();
    }

    public MainController mainController() {
        return new MainController(lottoConfig.lottoController(), purchaseConfig.purchaseController(),
                consoleInputHandler(), consoleOutputHandler());
    }

    private ConsoleInputHandler consoleInputHandler() {
        return new ConsoleInputHandler(inputProvider());
    }

    private ConsoleOutputHandler consoleOutputHandler() {
        return new ConsoleOutputHandler(stringFormatter());
    }

    private InputProvider inputProvider() {
        return new ConsoleInputProvider();
    }

    private StringFormatter stringFormatter() {
        return new StringFormatter();
    }

}
