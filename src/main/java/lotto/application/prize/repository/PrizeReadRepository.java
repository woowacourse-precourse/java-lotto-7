package lotto.application.prize.repository;

import static lotto.application.prize.repository.PrizeCommonStorage.getPrizeCommonStorage;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lotto.application.prize.domain.Prize;

public class PrizeReadRepository {

    private final ConcurrentHashMap repository = getPrizeCommonStorage();

    public PrizeReadRepository() {
    }

    public Optional<Prize> findById(Long prizeId) {
        return Optional.ofNullable((Prize) repository.get(prizeId));
    }

}
