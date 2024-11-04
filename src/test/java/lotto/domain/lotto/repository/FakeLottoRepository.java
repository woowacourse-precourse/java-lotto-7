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

    @Override
    public List<Lotto> findAllByBuyerId(UUID uuid) {
        return storage.values().stream()
            .filter(lotto -> lotto.isOwnedBy(uuid))
            .toList();
    }

    @Override
    public void saveAll(List<Lotto> lottos) {
        lottos.forEach(this::save);
    }

    public void clear() {
        storage.clear();
    }
}
