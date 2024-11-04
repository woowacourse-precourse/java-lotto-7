package lotto.repository;

import java.util.Optional;

public interface SingleRepository<T> {

    T save(T object);

    Optional<T> get();
}
