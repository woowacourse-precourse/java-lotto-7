package lotto.repository.prize;

import static lotto.repository.prize.PrizeCommonStorage.getPrizeCommonStorage;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.domain.prize.Prize;

public class PrizeReadRepository {

    private final ConcurrentHashMap repository = getPrizeCommonStorage();

    public PrizeReadRepository() {
    }

    public Optional<Prize> findById(Long prizeId) {
        return Optional.ofNullable((Prize) repository.get(prizeId));
    }
    
}
