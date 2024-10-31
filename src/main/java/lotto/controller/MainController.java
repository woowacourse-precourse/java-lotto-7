package lotto.controller;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.money.Money;
import lotto.model.rank.DrawResultRankTable;
import lotto.model.statistic.RecoveryRatio;
import lotto.service.LottoService;
import lotto.service.StatisticService;

public class MainController {

    private final LottoService lottoService;
    private final StatisticService statisticService;

    public MainController(final LottoService lottoService, final StatisticService statisticService) {
        this.lottoService = lottoService;
        this.statisticService = statisticService;
    }

    public void run() {
        // TODO: IO Operations
        Money purchasedAmount = Money.from(8000L);
        Lotto winning = Lotto.from(List.of(13, 14, 16, 38, 42, 45));
        Integer bonus = 13;

        Lottos mockLottos = Lottos.from(
                List.of(
                        Lotto.from(List.of(8, 21, 23, 41, 42, 43)),
                        Lotto.from(List.of(3, 5, 11, 16, 32, 38)),
                        Lotto.from(List.of(7, 11, 16, 35, 36, 44)),
                        Lotto.from(List.of(1, 8, 11, 31, 41, 42)),
                        Lotto.from(List.of(13, 14, 16, 38, 42, 45)),
                        Lotto.from(List.of(7, 11, 30, 40, 42, 43)),
                        Lotto.from(List.of(2, 13, 22, 32, 38, 45)),
                        Lotto.from(List.of(1, 3, 5, 14, 22, 45))
                )
        );

        Lottos lottos = lottoService.offerLottos(purchasedAmount);
        DrawResultRankTable drawResultRankTable = lottoService.rankMyLottos(mockLottos, winning, bonus);
        RecoveryRatio recoveryRatio = statisticService.returnOfInvestment(drawResultRankTable, purchasedAmount);
        System.out.println(recoveryRatio.toString());
    }
}
