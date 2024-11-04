package lotto.config;

import lotto.handler.EndHandler;
import lotto.handler.LottoHandler;
import lotto.handler.purchase.input.PurchaseAmountInputHandler;
import lotto.handler.purchase.printer.PurchaseLottosPrintHandler;
import lotto.handler.purchase.process.LottoGenerator;
import lotto.handler.purchase.process.PurchaseProcessHandler;
import lotto.handler.purchase.validation.PurchaseInputValidationHandler;
import lotto.handler.purchase.validation.PurchaseInputValidatorFactory;
import lotto.handler.rank.input.WinningNumberInputHandler;
import lotto.handler.rank.printer.WinningRankPrinterHandler;
import lotto.handler.rank.process.RankCounter;
import lotto.handler.rank.process.WinningRankHandler;
import lotto.handler.rank.validation.WinningNumberValidationHandler;
import lotto.handler.rank.validation.WinningNumberValidatorFactory;
import lotto.handler.statistics.printer.StatisticsPrinterHandler;
import lotto.handler.statistics.process.StatisticsCalculator;
import lotto.handler.statistics.process.StatisticsProcessHandler;

public class LottoHandlerDependencyConfig {
    private final LottoHandlerBuilder lottoHandlerBuilder;

    public LottoHandlerDependencyConfig(LottoHandlerBuilder lottoHandlerBuilder) {
        this.lottoHandlerBuilder = lottoHandlerBuilder;
    }

    public LottoHandler lottoHandler() {
        lottoHandlerBuilder.addNextHandler(new PurchaseAmountInputHandler())
                .addNextHandler(new PurchaseInputValidationHandler(purchaseInputValidatorFactory()))
                .addNextHandler(new PurchaseProcessHandler(lottoGenerator()))
                .addNextHandler(new PurchaseLottosPrintHandler())
                .addNextHandler(new WinningNumberInputHandler())
                .addNextHandler(new WinningNumberValidationHandler(winningNumberValidatorFactory()))
                .addNextHandler(new WinningRankHandler(rankCounter()))
                .addNextHandler(new WinningRankPrinterHandler())
                .addNextHandler(new StatisticsProcessHandler(statisticsCalculator()))
                .addNextHandler(new StatisticsPrinterHandler())
                .addNextHandler(new EndHandler());
        return lottoHandlerBuilder.build();
    }

    private LottoGenerator lottoGenerator() {
        return new LottoGenerator();
    }

    private PurchaseInputValidatorFactory purchaseInputValidatorFactory() {
        return new PurchaseInputValidatorFactory();
    }

    private RankCounter rankCounter() {
        return new RankCounter();
    }

    private WinningNumberValidatorFactory winningNumberValidatorFactory() {
        return new WinningNumberValidatorFactory();
    }

    private StatisticsCalculator statisticsCalculator() {
        return new StatisticsCalculator();
    }
}
