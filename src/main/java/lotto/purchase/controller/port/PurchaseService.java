package lotto.purchase.controller.port;

import lotto.purchase.domain.Purchase;
import lotto.purchase.domain.PurchaseResult;

public interface PurchaseService {

    Purchase createPurchase(long moneyValue);

    PurchaseResult getPurchaseResult(String purchaseId);
}
