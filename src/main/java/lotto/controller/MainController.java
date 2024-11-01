package lotto.controller;

import lotto.io.terminal.InputTerminal;
import lotto.io.terminal.OutputTerminal;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.money.Money;
import lotto.model.rank.DrawResultRankTable;
import lotto.model.statistic.RecoveryRatio;
import lotto.service.LottoService;
import lotto.service.StatisticService;
import lotto.view.LottosView;
import lotto.view.StatisticView;

public class MainController {

    private final InputTerminal inputTerminal;
    private final OutputTerminal outputTerminal;
    private final LottoService lottoService;
    private final StatisticService statisticService;

    public MainController(final InputTerminal inputTerminal,
                          final OutputTerminal outputTerminal,
                          final LottoService lottoService,
                          final StatisticService statisticService) {
        this.inputTerminal = inputTerminal;
        this.outputTerminal = outputTerminal;
        this.lottoService = lottoService;
        this.statisticService = statisticService;
    }

    public void run() {
        Money purchasedAmount = inputTerminal.readPurchaseAmount();
        int lottoCount = purchasedAmount.calculatePurchasedLottoCount();
        Lottos lottos = lottoService.offerLottos(lottoCount);
        LottosView lottosView = LottosView.from(lottos, lottoCount);
        outputTerminal.writeLottos(lottosView);

        Lotto drawResult = inputTerminal.readDrawResult();
        Integer bonusNumber = inputTerminal.readBonusNumber();

        DrawResultRankTable drawResultRankTable = lottoService.rankMyLottos(lottos, drawResult, bonusNumber);
        RecoveryRatio recoveryRatio = statisticService.returnOfInvestment(drawResultRankTable, purchasedAmount);
        StatisticView statisticView = StatisticView.from(drawResultRankTable, recoveryRatio);
        outputTerminal.writeStatistics(statisticView);
    }
}
