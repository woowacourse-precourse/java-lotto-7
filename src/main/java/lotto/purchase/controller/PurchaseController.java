package lotto.purchase.controller;

import lotto.purchase.controller.port.PurchaseService;
import lotto.purchase.domain.Purchase;
import lotto.purchase.domain.PurchaseResult;

public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    public Purchase createPurchase(long moneyValue) {
        return purchaseService.createPurchase(moneyValue);
    }

    public PurchaseResult getPurchaseResult(String purchaseId) {
        return purchaseService.getPurchaseResult(purchaseId);
    }
}
