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
        //AtomicInteger는 forEachLotto 메서드의 Consumer를 통해 각 Lotto의 상금을 누적하는 데 사용
        AtomicInteger totalPrize = new AtomicInteger(0);

        // Lottos 클래스의 forEachLotto 메서드는 Consumer 인터페이스를 사용하여 각 Lotto를 처리
        // Consumer는 각 Lotto에 대해 checkPrize 메서드를 호출하고, 해당 상금을 totalPrize에 더함
        lottos.forEachLotto(lotto ->
                totalPrize.addAndGet(winningCheckService.checkPrize(lotto, winningNumbers, winningStatistic))
        );
        return totalPrize.get();
    }
}
