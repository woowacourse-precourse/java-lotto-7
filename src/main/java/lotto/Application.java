package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoNumberGenerator;
import lotto.service.PriceCalculator;
import lotto.view.input.PromptDisplayer;
import lotto.view.input.PurchasePriceInput;
import lotto.view.output.ResultDisplayer;

public class Application {
    public static void main(String[] args) {
        PromptDisplayer promptDisplayer = new PromptDisplayer();
        PurchasePriceInput purchasePriceInput = new PurchasePriceInput(promptDisplayer);
        PriceCalculator priceCalculator = new PriceCalculator();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        ResultDisplayer resultDisplayer = new ResultDisplayer();
        LottoController lottoController = new LottoController(priceCalculator, purchasePriceInput, lottoNumberGenerator, resultDisplayer);
        lottoController.start();
    }
}
