package lotto.service;

import lotto.model.PurchasePrice;

public class InputParsingService {

    public PurchasePrice parsePurchasePrice(String rawPurchasePrice) {
        int price = Integer.parseInt(rawPurchasePrice);
        return new PurchasePrice(price);
    }
}
