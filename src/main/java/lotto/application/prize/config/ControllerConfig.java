package lotto.application.prize.config;

import lotto.application.prize.controller.PrizeController;
import lotto.application.prize.service.PrizeReadService;
import lotto.application.prize.service.PrizeWriteService;

public class ControllerConfig {

    private final PrizeController prizeController;

    public ControllerConfig(PrizeWriteService prizeWriteService, PrizeReadService prizeReadService) {
        this.prizeController = new PrizeController(
                prizeWriteService,
                prizeReadService
        );
    }

    public PrizeController getPrizeController() {
        return prizeController;
    }
}
