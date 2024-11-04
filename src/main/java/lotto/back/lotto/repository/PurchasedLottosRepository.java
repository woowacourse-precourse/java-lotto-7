package lotto.back.lotto.repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lotto.back.global.annotation.Repository;
import lotto.back.lotto.domain.Lottos;

@Repository
public class PurchasedLottosRepository {

    private final Map<UUID, Lottos> lottosContainer = new ConcurrentHashMap<>();


    public void save(Lottos lottos) {
        lottosContainer.put(lottos.getUuid(), lottos);
    }

    public Lottos findById(UUID uuid) {
        return lottosContainer.get(uuid);
    }
}
