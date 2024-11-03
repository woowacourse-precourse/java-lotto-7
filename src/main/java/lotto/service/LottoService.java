package lotto.service;

import static java.lang.Integer.parseInt;

public class LottoService {

    public int calculatePurchaseQuantity(String purchaseAmount) {
        return parseInt(purchaseAmount) / 1000;
    }
}
