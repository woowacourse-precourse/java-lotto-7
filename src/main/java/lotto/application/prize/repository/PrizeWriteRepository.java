package lotto.application.prize.repository;

import static lotto.application.prize.repository.PrizeCommonStorage.getPrizeCommonStorage;

import java.util.concurrent.ConcurrentHashMap;
import lotto.application.prize.domain.Prize;

public class PrizeWriteRepository {
    private final ConcurrentHashMap repository = getPrizeCommonStorage();

    public PrizeWriteRepository() {
    }

    public Long save(Prize prize) {
        repository.put(prize.getId(), prize);

        return prize.getId();
    }

}

