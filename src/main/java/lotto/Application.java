package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoNumberGenerator;
import lotto.service.PriceCalculator;
import lotto.service.WinningNumberSplitter;
import lotto.view.input.PromptDisplayer;
import lotto.view.input.PurchasePriceInput;
import lotto.view.input.WinningNumberInput;
import lotto.view.output.ResultDisplayer;

public class Application {
    public static void main(String[] args) {
        PromptDisplayer promptDisplayer = new PromptDisplayer();
        PurchasePriceInput purchasePriceInput = new PurchasePriceInput(promptDisplayer);
        PriceCalculator priceCalculator = new PriceCalculator();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        ResultDisplayer resultDisplayer = new ResultDisplayer();
        WinningNumberSplitter winningNumberSplitter = new WinningNumberSplitter();
        WinningNumberInput winningNumberInput = new WinningNumberInput(promptDisplayer);
        LottoController lottoController = new LottoController(priceCalculator, purchasePriceInput, lottoNumberGenerator, resultDisplayer, winningNumberSplitter, winningNumberInput);
        lottoController.start();
    }
}
