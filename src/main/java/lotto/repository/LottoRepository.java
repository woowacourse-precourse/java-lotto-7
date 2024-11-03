package lotto.repository;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoRepository {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private Map<Integer, Lotto> lottos = new HashMap<>();

    public void saveAll(List<Lotto> lottos) {
        lottos.forEach(this::save);
    }

    public void save(Lotto lotto) {
        lottos.put(ID_GENERATOR.incrementAndGet(), lotto);
    }

    public List<Lotto> findAll() {
        return List.copyOf(lottos.values());
    }
}
