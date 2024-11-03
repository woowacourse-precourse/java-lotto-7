package store.repository;

import store.model.Store;

public class StoreSingleRepositoryImpl implements StoreSingleRepository {

    private static Store store = new Store();

    @Override
    public void save(Store store) {
        this.store = store;
    }

    @Override
    public Store find() {
        return store;
    }
}
