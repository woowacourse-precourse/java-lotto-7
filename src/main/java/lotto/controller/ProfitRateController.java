package lotto.controller;

import lotto.dto.ProfitRateResultDto;
import lotto.service.ProfitRateService;
import lotto.viewer.Viewer;

public class ProfitRateController {

    private final ProfitRateService profitRateService;
    private final Viewer viewer;

    public ProfitRateController(ProfitRateService profitRateService, Viewer viewer) {
        this.profitRateService = profitRateService;
        this.viewer = viewer;
    }

    public void print() {
        ProfitRateResultDto profitRateResultDto = profitRateService.calculate();
        viewer.printMessage(profitRateResultDto.resultMessage());
    }
}
