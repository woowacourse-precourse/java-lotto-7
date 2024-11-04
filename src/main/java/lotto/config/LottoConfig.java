package lotto.config;


import lotto.controller.LottoController;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoPrizeCalculator;
import lotto.service.PriceCalculator;
import lotto.service.WinningNumberParser;
import lotto.view.input.PromptDisplayer;
import lotto.view.input.PurchasePriceInput;
import lotto.view.input.WinningNumberInput;
import lotto.view.output.ResultDisplayer;

public class LottoConfig {
    public LottoController lottoController() {
        PromptDisplayer promptDisplayer = new PromptDisplayer();
        PurchasePriceInput purchasePriceInput = new PurchasePriceInput(promptDisplayer);
        PriceCalculator priceCalculator = new PriceCalculator();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        ResultDisplayer resultDisplayer = new ResultDisplayer();
        WinningNumberParser winningNumberParser = new WinningNumberParser();
        WinningNumberInput winningNumberInput = new WinningNumberInput(promptDisplayer);
        LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator();

        return new LottoController(priceCalculator, purchasePriceInput, lottoNumberGenerator, resultDisplayer,
                winningNumberParser, winningNumberInput, lottoPrizeCalculator);
    }
}
