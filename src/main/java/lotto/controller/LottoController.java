package lotto.controller;

import lotto.domain.PurchasedPrice;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        PurchasedPrice purchasedPrice = new PurchasedPrice(InputView.readPurchasePrice());
    }
}
