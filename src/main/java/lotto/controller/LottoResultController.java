package lotto.controller;

import lotto.model.LottoRankCounter;
import lotto.service.LottoCalculationService;
import lotto.view.LottoResultView;
import lotto.view.View;

public class LottoResultController implements Controller {

    private final LottoCalculationService calculationService = new LottoCalculationService();

    @Override
    public View execute() {
        LottoRankCounter rankCnts = calculationService.getRankCnts();
        double rateOfReturn = calculationService.getRateOfReturn(rankCnts);
        return new LottoResultView(rankCnts, rateOfReturn);
    }
}
