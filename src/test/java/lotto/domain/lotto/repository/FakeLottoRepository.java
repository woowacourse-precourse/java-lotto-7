package lotto.domain.lotto.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.lotto.Lotto;

public class FakeLottoRepository implements LottoRepository {

    private static Map<UUID, Lotto> storage = new ConcurrentHashMap<>();

    @Override
    public void save(Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException();
        }

        storage.put(lotto.getId(), lotto);
    }

    @Override
    public List<Lotto> findAll() {
        return List.copyOf(storage.values());
    }

    public void clear() {
        storage.clear();
    }
}
