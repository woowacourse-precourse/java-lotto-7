package lotto.presentation.controller;

import lotto.domain.LottoPurchase;
import lotto.domain.winning.Winning;
import lotto.presentation.controller.common.LottoController;
import lotto.presentation.model.Key;
import lotto.presentation.model.Model;
import lotto.presentation.view.OutputView;
import lotto.service.winning.LottoStatistics;
import lotto.service.winning.WinningService;

public class StatisticsController extends LottoController {

    private final WinningService winningService;

    public StatisticsController(WinningService winningService) {
        this.winningService = winningService;
    }

    @Override
    protected void request(Model model) {
        //do Nothing
    }

    @Override
    protected void handle(Model model) {
        LottoPurchase purchase = (LottoPurchase) model.get(Key.LOTTO_PURCHASE);
        Winning winning = (Winning) model.get(Key.WINNING);

        LottoStatistics statistics = winningService.estimate(purchase, winning);
        model.put(Key.STATISTICS, statistics);
    }

    @Override
    protected void response(Model model) {
        LottoStatistics statistics = (LottoStatistics) model.get(Key.STATISTICS);
        OutputView.render(statistics);
    }
}
