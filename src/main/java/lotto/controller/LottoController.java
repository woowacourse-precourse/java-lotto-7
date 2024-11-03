package lotto.controller;

import lotto.service.PriceCalculator;
import lotto.view.input.PurchasePriceInput;

public class LottoController {

    private final PurchasePriceInput purchasePriceInput;
    private final PriceCalculator priceCalculator;

    public LottoController(PriceCalculator priceCalculator, PurchasePriceInput purchasePriceInput) {
        this.purchasePriceInput = purchasePriceInput;
        this.priceCalculator = priceCalculator;
    }

    public void start() {
        String price = purchasePriceInput.getPurchasePrice();
        priceCalculator.calculateLotto(price);
    }
}
