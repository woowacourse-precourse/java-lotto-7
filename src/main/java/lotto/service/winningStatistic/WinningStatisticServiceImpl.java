package lotto.service.winningStatistic;

import lotto.factory.WinningStatisticFactory;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.service.prize.TotalPrizeCalculatorService;
import lotto.util.Calculator;

public class WinningStatisticServiceImpl implements WinningStatisticService {
    private final TotalPrizeCalculatorService totalPrizeCalculatorService;

    public WinningStatisticServiceImpl(TotalPrizeCalculatorService totalPrizeCalculatorService) {
        this.totalPrizeCalculatorService = totalPrizeCalculatorService;
    }

    @Override
    public WinningStatistic calculateWinningStatistic(int cost, Lottos lottos, WinningNumbers winningNumbers) {
        WinningStatistic winningStatistic = WinningStatisticFactory.createWinningStatistic();

        int totalPrize = totalPrizeCalculatorService.calculateTotalPrize(lottos, winningNumbers, winningStatistic);

        double profitRate = Calculator.calculateProfitRate(cost, totalPrize);

        return WinningStatisticFactory.createWinningStatisticWithProfitRate(winningStatistic, profitRate);
    }
}
