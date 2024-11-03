package lotto.repository.prize;

import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.prize.Prize;

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
