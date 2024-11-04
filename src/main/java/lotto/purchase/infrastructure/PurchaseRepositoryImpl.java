package lotto.purchase.infrastructure;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.purchase.domain.Purchase;
import lotto.purchase.service.port.PurchaseRepository;

public class PurchaseRepositoryImpl implements PurchaseRepository {

    private static PurchaseRepository instance;
    private final Map<String, Purchase> purchaseCache = new ConcurrentHashMap<>();

    private PurchaseRepositoryImpl() {
    }

    public static PurchaseRepository getInstance() {
        if (instance == null) {
            synchronized (PurchaseRepositoryImpl.class) {
                if (instance == null) {
                    instance = new PurchaseRepositoryImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Purchase findById(String id) {
        try {
            return Optional.ofNullable(purchaseCache.get(id))
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 id값이 존재하지 않습니다."));
        } catch (NullPointerException e) {
            throw new IllegalStateException("[ERROR] 해당 id 값이 null일 수 없습니다.");
        }
    }

    @Override
    public Purchase save(String id, Purchase purchase) {
        try {
            purchaseCache.put(id, purchase);
            return purchase;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] key 또는 value에 null이 존재할 수 없습니다");
        }
    }
}
