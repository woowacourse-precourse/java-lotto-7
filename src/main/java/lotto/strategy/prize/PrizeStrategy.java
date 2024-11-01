package lotto.strategy.prize;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;

public interface PrizeStrategy {
    boolean isWinning(Lotto lotto, WinningNumbers winningNumbers);

    int getPrizeAmount();
}
