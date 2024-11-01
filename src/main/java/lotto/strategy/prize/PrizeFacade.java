package lotto.strategy.prize;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

public class PrizeFacade {
    List<PrizeStrategy> prizeStrategies;

    public PrizeFacade(List<PrizeStrategy> prizeStrategies) {
        this.prizeStrategies = prizeStrategies;
    }

    public PrizeStrategy getWinningStrategy(Lotto lotto, WinningNumbers winningNumbers) {
        for (PrizeStrategy prizeStrategy : prizeStrategies) {
            if (prizeStrategy.isWinning(lotto, winningNumbers)) {
                return prizeStrategy;
            }
        }
        return null;
    }
}
