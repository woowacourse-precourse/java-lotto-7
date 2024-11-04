package lotto.infrastructure.persistence;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.lotto.Lotto;

public class LottoMemoryRepository {

    private static final Map<UUID, Lotto> storage = new ConcurrentHashMap<>();

    public void save(Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException();
        }

        storage.put(lotto.getId(), lotto);
    }

    public List<Lotto> findAll() {
        return List.copyOf(storage.values());
    }

    public List<Lotto> findAllByBuyerId(UUID uuid) {
        return storage.values().stream()
            .filter(lotto -> lotto.isOwnedBy(uuid))
            .toList();
    }

    public void saveAll(List<Lotto> lottos) {
        lottos.forEach(this::save);
    }
}
