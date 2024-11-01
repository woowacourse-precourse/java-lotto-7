package lotto.service;

import lotto.domain.Purchase;

public class PurchaseService {

    public int buyLotto(int price) {
        Purchase purchase = new Purchase(price);
        return purchase.calculatePurchasableLotto();
    }
}
