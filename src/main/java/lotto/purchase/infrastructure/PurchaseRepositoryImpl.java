package lotto.purchase.infrastructure;

import static lotto.common.exception.ExceptionName.REPOSITORY_ID_NULL;
import static lotto.common.exception.ExceptionName.REPOSITORY_NOT_FOUND;
import static lotto.common.exception.ExceptionName.REPOSITORY_VALUE_NULL;

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
                    .orElseThrow(() -> new IllegalArgumentException(REPOSITORY_NOT_FOUND));
        } catch (NullPointerException e) {
            throw new IllegalStateException(REPOSITORY_ID_NULL);
        }
    }

    @Override
    public Purchase save(String id, Purchase purchase) {
        if (id == null) {
            throw new IllegalArgumentException(REPOSITORY_ID_NULL);
        }
        if (purchase == null) {
            throw new IllegalArgumentException(REPOSITORY_VALUE_NULL);
        }
        purchaseCache.put(id, purchase);
        return purchase;
    }
}
