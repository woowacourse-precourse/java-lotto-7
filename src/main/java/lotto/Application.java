package lotto;

import lotto.controller.LottoController;
import lotto.service.PriceCalculator;
import lotto.view.input.PromptDisplayer;
import lotto.view.input.PurchasePriceInput;

public class Application {
    public static void main(String[] args) {
        PromptDisplayer promptDisplayer = new PromptDisplayer();
        PurchasePriceInput purchasePriceInput = new PurchasePriceInput(promptDisplayer);
        PriceCalculator priceCalculator = new PriceCalculator();
        LottoController lottoController = new LottoController(priceCalculator, purchasePriceInput);
        lottoController.start();
    }
}
