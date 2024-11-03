package lotto.controller;

import lotto.model.Lottos;
import lotto.validator.PurchasePriceValidator;
import lotto.view.InputView;

public class LottoGameController {

    private final InputView inputView;
    private final PurchasePriceValidator purchasePriceValidator;

    private final static int LOTTO_PRICE = 1000;

    public LottoGameController(InputView inputView, PurchasePriceValidator purchasePriceValidator) {
        this.inputView = inputView;
        this.purchasePriceValidator = purchasePriceValidator;
    }

    public void run() {
        String purchasePrice = getPurchasePrice();
        Lottos lottos = Lottos.randomFrom(Integer.parseInt(purchasePrice) / LOTTO_PRICE);
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
