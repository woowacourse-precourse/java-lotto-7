package lotto.repository;

import java.util.Optional;

public interface SingleRepository<T> {

    void save(T object);

    Optional<T> get();
}
