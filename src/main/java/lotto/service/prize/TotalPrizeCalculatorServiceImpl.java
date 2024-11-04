package lotto.service.prize;

import java.util.concurrent.atomic.AtomicInteger;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistic;
import lotto.service.winningCheck.WinningCheckService;

public class TotalPrizeCalculatorServiceImpl implements TotalPrizeCalculatorService {
    private final WinningCheckService winningCheckService;

    public TotalPrizeCalculatorServiceImpl(WinningCheckService winningCheckService) {
        this.winningCheckService = winningCheckService;
    }

    @Override
    public int calculateTotalPrize(Lottos lottos, WinningNumbers winningNumbers, WinningStatistic winningStatistic) {
        AtomicInteger totalPrize = new AtomicInteger(0);
        lottos.forEachLotto(lotto ->
                totalPrize.addAndGet(winningCheckService.checkPrize(lotto, winningNumbers, winningStatistic))
        );
        return totalPrize.get();
    }
}
