package lotto.application.prize.config;

import lotto.application.common.IdGenerator;
import lotto.application.prize.repository.PrizeReadRepository;
import lotto.application.prize.repository.PrizeWriteRepository;
import lotto.application.prize.service.PrizeIdGenerator;
import lotto.application.prize.view.input.PrizeInputView;

public class PrizeAppConfig {
    private final ViewConfig viewConfig;
    private final ControllerConfig controllerConfig;
    private final ServiceConfig serviceConfig;
    private final RepositoryConfig repositoryConfig;

    public PrizeAppConfig() {
        this.viewConfig = new ViewConfig(getPrizeInputView());
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

    public ControllerConfig getControllerConfig() {
        return controllerConfig;
    }

    private IdGenerator getIdGenerator() {
        return new PrizeIdGenerator();
    }

    private PrizeInputView getPrizeInputView() {
        return new PrizeInputView();
    }

    private PrizeWriteRepository getPrizeWriteRepository() {
        return new PrizeWriteRepository();
    }

    private PrizeReadRepository getPrizeReadRepository() {
        return new PrizeReadRepository();
    }
}
