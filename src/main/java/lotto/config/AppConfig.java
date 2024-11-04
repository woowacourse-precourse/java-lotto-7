package lotto.config;

import lotto.io.input.BonusNumberInputConsoleHandler;
import lotto.io.input.BuyingAmountInputConsoleHandler;
import lotto.io.input.WinningNumbersInputConsoleHandler;
import lotto.io.output.WinningResultStatisticsOutputConsoleHandler;
import lotto.lotto.providable.NumbersProvidable;
import lotto.lotto.providable.RandomUniqueNumbersProvider;

public class AppConfig {
    private final NumbersProvidable numbersProvidable;
    private final BuyingAmountInputConsoleHandler buyingAmountInputConsoleHandler;
    private final WinningNumbersInputConsoleHandler winningNumbersInputConsoleHandler;
    private final BonusNumberInputConsoleHandler bonusNumberInputConsoleHandler;
    private final WinningResultStatisticsOutputConsoleHandler winningResultStatisticsOutputConsoleHandler;


    private AppConfig(NumbersProvidable numbersProvidable,
                      BuyingAmountInputConsoleHandler buyingAmountInputConsoleHandler,
                      WinningNumbersInputConsoleHandler winningNumbersInputConsoleHandler,
                      BonusNumberInputConsoleHandler bonusNumberInputConsoleHandler,
                      WinningResultStatisticsOutputConsoleHandler winningResultStatisticsOutputConsoleHandler) {
        this.numbersProvidable = numbersProvidable;
        this.buyingAmountInputConsoleHandler = buyingAmountInputConsoleHandler;
        this.winningNumbersInputConsoleHandler = winningNumbersInputConsoleHandler;
        this.bonusNumberInputConsoleHandler = bonusNumberInputConsoleHandler;
        this.winningResultStatisticsOutputConsoleHandler = winningResultStatisticsOutputConsoleHandler;
    }

    public static AppConfig getAppConfig() {
        return new AppConfig(
                new RandomUniqueNumbersProvider(),
                new BuyingAmountInputConsoleHandler(),
                new WinningNumbersInputConsoleHandler(),
                new BonusNumberInputConsoleHandler(),
                new WinningResultStatisticsOutputConsoleHandler()
        );
    }

    public NumbersProvidable getNumbersProvidable() {
        return numbersProvidable;
    }

    public BuyingAmountInputConsoleHandler getBuyingAmountInputConsoleHandler() {
        return buyingAmountInputConsoleHandler;
    }

    public WinningNumbersInputConsoleHandler getWinningNumbersInputConsoleHandler() {
        return winningNumbersInputConsoleHandler;
    }

    public BonusNumberInputConsoleHandler getBonusNumberInputConsoleHandler() {
        return bonusNumberInputConsoleHandler;
    }

    public WinningResultStatisticsOutputConsoleHandler getWinningResultStatisticsOutputConsoleHandler() {
        return winningResultStatisticsOutputConsoleHandler;
    }
}
