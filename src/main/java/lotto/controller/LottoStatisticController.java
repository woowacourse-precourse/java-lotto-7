package lotto.controller;

import lotto.model.vo.WinningNumber;
import lotto.service.LottoStatisticService;
import lotto.view.OutputView;

public class LottoStatisticController {
    private final LottoStatisticService lottoStatisticService;

    public LottoStatisticController(LottoStatisticService lottoStatisticService) {
        this.lottoStatisticService = lottoStatisticService;
    }

    public void calculate(WinningNumber winningNumber) {
        OutputView.printLottoStatistic(lottoStatisticService.calculateStatistic(winningNumber));
    }
}
