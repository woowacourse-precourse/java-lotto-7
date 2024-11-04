package lotto.domain.lotto.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.lotto.Lotto;

public class FakeLottoRepository implements LottoRepository {

    private static Map<Long, Lotto> storage = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public void save(Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException();
        }

        storage.put(sequence++, lotto);
    }

    @Override
    public List<Lotto> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public void saveAll(List<Lotto> lottos) {
        lottos.forEach(this::save);
    }

    public void clear() {
        storage.clear();
    }
}
