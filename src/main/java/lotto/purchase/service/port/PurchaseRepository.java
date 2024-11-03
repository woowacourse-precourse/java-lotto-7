package lotto.purchase.service.port;

import lotto.purchase.domain.Purchase;

public interface PurchaseRepository {

    Purchase findById(String id);

    Purchase save(String id, Purchase purchase);
}
