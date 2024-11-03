package lotto.controller;

import lotto.service.LottoCalculationService;
import lotto.view.LottoResultView;
import lotto.view.View;

public class LottoResultController implements Controller {

    private final LottoCalculationService calculationService = new LottoCalculationService();

    @Override
    public View execute() {
        int[] rankCnts = calculationService.getRankCnts();
        double rateOfReturn = calculationService.getRateOfReturn(rankCnts);
        return new LottoResultView(rankCnts, rateOfReturn);
    }
}
