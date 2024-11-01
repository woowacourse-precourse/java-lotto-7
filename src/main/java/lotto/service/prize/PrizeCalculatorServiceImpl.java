package lotto.service.prize;

import java.util.concurrent.atomic.AtomicInteger;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.strategy.prize.PrizeFacade;

public class PrizeCalculatorServiceImpl implements PrizeCalculatorService {
    private final PrizeFacade prizeFacade;

    public PrizeCalculatorServiceImpl(PrizeFacade prizeFacade) {
        this.prizeFacade = prizeFacade;
    }

    @Override
    public int calculateTotalPrize(Lottos lottos) {
        AtomicInteger totalPrize = new AtomicInteger(0);
        lottos.forEachLotto(lotto -> {
            var winningStrategy = prizeFacade.getWinningStrategy(lotto, WinningNumbers.getInstance());
            if (winningStrategy != null) {
                totalPrize.addAndGet(winningStrategy.getPrizeAmount());
            }
        });
        return totalPrize.get();
    }

}
