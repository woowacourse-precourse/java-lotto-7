package lotto.controller;

import lotto.service.LottoCalculationService;
import lotto.view.LottoResultView;
import lotto.view.View;

public class LottoResultController implements Controller {

    private final LottoCalculationService calculationService = new LottoCalculationService();

    @Override
    public View execute() {
        int[] matchCnts = calculationService.getMatchCnts();
        double rateOfReturn = calculationService.getRateOfReturn(matchCnts);
        return new LottoResultView(matchCnts, rateOfReturn);
    }
}
