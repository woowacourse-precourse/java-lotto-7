package lotto.controller;

import lotto.service.RankService;
import lotto.service.RateService;
import lotto.view.OutputRanking;
import lotto.view.OutputRate;

public class RateController {

    private final OutputRate outputRate;

    public RateController() {
        this.outputRate = new OutputRate();
    }

    public void calculateRate(RankService ranking, int amount) {
        double rate = RateService.calculateRate(ranking, amount);
        outputRate.rateOutput(rate);
    }

}
