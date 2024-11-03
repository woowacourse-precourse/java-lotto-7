package lotto.utils;

import lotto.controller.LottoMachine;
import lotto.domain.LottoDrawer;
import lotto.domain.calculator.Calculator;
import lotto.domain.calculator.ProfitCalculator;
import lotto.domain.calculator.PurchaseCalculator;
import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.domain.lottoGeneratir.RandomLottoGenerator;
import lotto.domain.lottoMatchChecker.DefaultLottoMatchChecker;
import lotto.domain.lottoMatchChecker.LottoMatchChecker;
import lotto.service.LottoGenerateManager;
import lotto.service.LottoPurchaseManager;
import lotto.service.LottoResultManager;
import lotto.view.InputOutputManager;

public class AppConfig {
    public Calculator purchaseCalculator() {
        return new PurchaseCalculator();
    }

    public LottoDrawer lottoDrawer() {
        return new LottoDrawer();
    }

    public LottoGenerator lottoGenerator() {
        return new RandomLottoGenerator();
    }

    public LottoMatchChecker lottoMatchChecker() {
        return new DefaultLottoMatchChecker();
    }

    public Calculator profitCalculator() {
        return new ProfitCalculator();
    }

    public InputOutputManager inputOutputManager() {
        return new InputOutputManager();
    }

    public LottoPurchaseManager lottoPurchaseManager() {
        return new LottoPurchaseManager(purchaseCalculator(), lottoDrawer(), lottoGenerator());
    }

    public LottoGenerateManager lottoGenerateManager() {
        return new LottoGenerateManager(lottoGenerator());
    }

    public LottoResultManager lottoResultManager() {
        return new LottoResultManager(lottoMatchChecker(), profitCalculator());
    }

    public LottoMachine lottoMachine() {
        return new LottoMachine(inputOutputManager(), lottoPurchaseManager(), lottoGenerateManager(),
                lottoResultManager());
    }
}
