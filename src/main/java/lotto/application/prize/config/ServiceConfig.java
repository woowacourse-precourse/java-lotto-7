package lotto.application.prize.config;

import lotto.application.common.IdGenerator;
import lotto.application.prize.repository.PrizeReadRepository;
import lotto.application.prize.repository.PrizeWriteRepository;
import lotto.application.prize.service.CreatePrizeNumberService;
import lotto.application.prize.service.PrizeReadService;
import lotto.application.prize.service.PrizeWriteService;

public class ServiceConfig {
    private final PrizeWriteService prizeWriteService;
    private final PrizeReadService prizeReadService;

    public ServiceConfig(
            PrizeWriteRepository prizeWriteRepository,
            PrizeReadRepository prizeReadRepository,
            IdGenerator idGenerator) {

        this.prizeWriteService = new PrizeWriteService(
                new CreatePrizeNumberService(),
                prizeWriteRepository,
                idGenerator
        );
        this.prizeReadService = new PrizeReadService(prizeReadRepository);
    }

    public PrizeWriteService getPrizeWriteService() {
        return prizeWriteService;
    }

    public PrizeReadService getPrizeReadService() {
        return prizeReadService;
    }
}
