package store.repository;

import store.model.Store;

public class StoreRepositoryImpl implements StoreRepository {

    private Store store;

    public StoreRepositoryImpl() {
        store = new Store();
    }

    @Override
    public void save(Store store) {
        this.store = store;
    }

    @Override
    public Store findOne() {
        return store;
    }
}
