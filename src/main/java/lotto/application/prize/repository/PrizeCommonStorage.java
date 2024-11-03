package lotto.application.prize.repository;

import java.util.concurrent.ConcurrentHashMap;
import lotto.application.prize.domain.Prize;

public class PrizeCommonStorage {

    private static final ConcurrentHashMap<Long, Prize> repository = new ConcurrentHashMap<>();

    private PrizeCommonStorage() {
    }

    public static ConcurrentHashMap<Long, Prize> getPrizeCommonStorage() {
        return repository;
    }

    public static void clear() {
        repository.clear();
    }

}
