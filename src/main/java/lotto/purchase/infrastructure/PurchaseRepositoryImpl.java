package lotto.purchase.infrastructure;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.purchase.domain.Purchase;
import lotto.purchase.service.port.PurchaseRepository;

public class PurchaseRepositoryImpl implements PurchaseRepository {

    private static PurchaseRepository instance;
    private final Map<String, Purchase> purchaseResultMap = new ConcurrentHashMap<>();

    private PurchaseRepositoryImpl() {}

    public static PurchaseRepository getInstance() {
        if (instance == null) {
            instance = new PurchaseRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Purchase findById(String id) {
        try {
            return purchaseResultMap.get(id);
        } catch (NullPointerException e) {
            throw new NullPointerException("[ERROR] 해당 id 값이 존재하지 않습니다.");
        }
    }

    @Override
    public Purchase save(String id, Purchase purchase) {
        purchaseResultMap.put(id, purchase);
        return purchase;
    }
}
