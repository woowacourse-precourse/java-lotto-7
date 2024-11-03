package store.repository;

import store.model.Store;

public interface StoreSingleRepository {
    void save(Store store);
    Store find();
}
