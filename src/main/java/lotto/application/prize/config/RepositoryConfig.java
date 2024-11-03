package lotto.application.prize.config;

import lotto.application.prize.repository.PrizeReadRepository;
import lotto.application.prize.repository.PrizeWriteRepository;

public class RepositoryConfig {
    private final PrizeWriteRepository prizeWriteRepository;
    private final PrizeReadRepository prizeReadRepository;

    public RepositoryConfig(PrizeWriteRepository prizeWriteRepository, PrizeReadRepository prizeReadRepository) {
        this.prizeWriteRepository = prizeWriteRepository;
        this.prizeReadRepository = prizeReadRepository;
    }

    public PrizeWriteRepository getPrizeWriteRepository() {
        return prizeWriteRepository;
    }

    public PrizeReadRepository getPrizeReadRepository() {
        return prizeReadRepository;
    }

}
