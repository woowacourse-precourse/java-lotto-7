package lotto.service.statistic;

import java.util.List;
import lotto.factory.LottoFactory;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.model.WinningStatistic.PrizeTier;
import lotto.service.statistic.prize.PrizeCalculatorService;
import lotto.util.Calculator;

public class StatisticServiceImpl implements StatisticService {
    private final PrizeCalculatorService prizeCalculatorService;

    public StatisticServiceImpl(PrizeCalculatorService prizeCalculatorService) {
        this.prizeCalculatorService = prizeCalculatorService;
    }

    @Override
    public WinningStatistic getStatistic(int purchaseAmount, int cost, List<Integer> numbers,
                                         int bonusNumber, Lottos lottos) {

        initializeWinningNumbers(numbers, bonusNumber);

        WinningNumbers winningNumbers = WinningNumbers.getInstance();

        int totalPrize = calculateTotalPrize(lottos, winningNumbers);

        double profitRate = Calculator.calculateProfitRate(cost, totalPrize);

        WinningStatistic winningStatistic = new WinningStatistic(profitRate);

        lottos.forEachLotto(lotto -> checkPrizeAndIncreaseCount(lotto, winningStatistic, winningNumbers));

        return winningStatistic;
    }

    private int calculateTotalPrize(Lottos lottos, WinningNumbers winningNumbers) {
        return prizeCalculatorService.calculateTotalPrize(lottos, winningNumbers);
    }

    private void initializeWinningNumbers(List<Integer> numbers, int bonusNumber) {
        Lotto winningLotto = LottoFactory.creatLotto(numbers);
        WinningNumbers.initializeInstance(winningLotto, bonusNumber);
    }

    private void checkPrizeAndIncreaseCount(Lotto lotto, WinningStatistic winningStatistic,
                                            WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.getMatchCount(lotto);
        boolean isBonusNumberMatched = winningNumbers.isBonusNumberMatched(lotto);

        if (matchCount == 3) {
            winningStatistic.addPrizeCount(PrizeTier.FIFTH);
            return;
        }

        if (matchCount == 4) {
            winningStatistic.addPrizeCount(PrizeTier.FOURTH);
            return;
        }

        if (matchCount == 5 && isBonusNumberMatched) {
            winningStatistic.addPrizeCount(PrizeTier.SECOND);
            return;
        }

        if (matchCount == 5) {
            winningStatistic.addPrizeCount(PrizeTier.THIRD);
            return;
        }

        if (matchCount == 6) {
            winningStatistic.addPrizeCount(PrizeTier.FIRST);
        }
    }

}
