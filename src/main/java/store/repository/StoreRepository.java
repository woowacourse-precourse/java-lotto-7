package store.repository;

import store.model.Store;

public interface StoreRepository {
    void save(Store store);

    Store findOne();
}
