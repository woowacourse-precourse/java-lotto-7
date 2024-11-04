package lotto.infrastructure.persistence;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.lotto.Lotto;

public class LottoMemoryRepository {

    private static final Map<Long, Lotto> storage = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    public void save(Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException();
        }

        storage.put(sequence++, lotto);
    }

    public List<Lotto> findAll() {
        return List.copyOf(storage.values());
    }

    public void saveAll(List<Lotto> lottos) {
        lottos.forEach(this::save);
    }
}
