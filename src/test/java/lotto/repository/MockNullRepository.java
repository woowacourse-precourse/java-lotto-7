package lotto.repository;

import java.util.Optional;

public class MockNullRepository implements SingleRepository<Object> {

    @Override
    public Object save(Object object) {
        return null;
    }

    @Override
    public Optional<Object> get() {
        return Optional.empty();
    }
}
