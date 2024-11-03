package lotto.repository.prize;

import static lotto.repository.prize.PrizeCommonStorage.getPrizeCommonStorage;

import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.prize.Prize;

public class PrizeWriteRepository {
    private final ConcurrentHashMap repository = getPrizeCommonStorage();

    public PrizeWriteRepository() {
    }

    public Long save(Prize prize) {
        repository.put(prize.getId(), prize);

        return prize.getId();
    }

}

