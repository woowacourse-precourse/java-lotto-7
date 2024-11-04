package lotto.back.lotto.repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lotto.back.global.annotation.Repository;
import lotto.back.lotto.domain.Lotto;

@Repository
public class PrizeLottoRepository {

    private final Map<UUID, Lotto> lottoContainer = new ConcurrentHashMap<>();


    public void save(UUID uuid, Lotto lotto) {
        lottoContainer.put(uuid, lotto);
    }

    public Lotto findById(UUID uuid) {
        return lottoContainer.get(uuid);
    }
}
