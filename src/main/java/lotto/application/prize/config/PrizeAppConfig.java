package lotto.application.prize.config;

import lotto.application.common.IdGenerator;
import lotto.application.prize.controller.PrizeController;
import lotto.application.prize.repository.PrizeReadRepository;
import lotto.application.prize.repository.PrizeWriteRepository;
import lotto.application.prize.service.PrizeIdGenerator;

public class PrizeAppConfig {
    private final ControllerConfig controllerConfig;
    private final ServiceConfig serviceConfig;
    private final RepositoryConfig repositoryConfig;

    public PrizeAppConfig() {
        this.repositoryConfig = new RepositoryConfig(
                getPrizeWriteRepository(),
                getPrizeReadRepository()
        );
        this.serviceConfig = new ServiceConfig(
                repositoryConfig.getPrizeWriteRepository(),
                repositoryConfig.getPrizeReadRepository(),
                getIdGenerator()
        );
        this.controllerConfig = new ControllerConfig(
                serviceConfig.getPrizeWriteService(),
                serviceConfig.getPrizeReadService()
        );
    }

    public PrizeController getPrizeController() {
        return controllerConfig.getPrizeController();
    }

    private IdGenerator getIdGenerator() {
        return new PrizeIdGenerator();
    }


    private PrizeWriteRepository getPrizeWriteRepository() {
        return new PrizeWriteRepository();
    }

    private PrizeReadRepository getPrizeReadRepository() {
        return new PrizeReadRepository();
    }
}
