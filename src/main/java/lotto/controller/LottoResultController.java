package lotto.controller;

import lotto.model.LottoRank;
import lotto.service.LottoCalculationService;
import lotto.view.LottoResultView;
import lotto.view.View;

public class LottoResultController implements Controller {

    private final LottoCalculationService calculationService = new LottoCalculationService();

    @Override
    public View execute() {
        LottoRank rank = calculationService.getRankCnts();
        double rateOfReturn = calculationService.getRateOfReturn(rank);
        return new LottoResultView(rank, rateOfReturn);
    }
}
