package lotto.controller;

import lotto.validator.PurchasePriceValidator;
import lotto.view.InputView;

public class LottoGameController {

    private final InputView inputView;
    private final PurchasePriceValidator purchasePriceValidator;

    public LottoGameController(InputView inputView, PurchasePriceValidator purchasePriceValidator) {
        this.inputView = inputView;
        this.purchasePriceValidator = purchasePriceValidator;
    }

    public void run() {
        String purchasePrice = getPurchasePrice();
    }

    private String getPurchasePrice() {
        String purchasePrice = "";
        try {
            purchasePrice = inputView.getPurchasePrice();
            purchasePriceValidator.validate(purchasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPurchasePrice();
        }
        return purchasePrice;
    }

}
