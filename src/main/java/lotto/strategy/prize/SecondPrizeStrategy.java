package lotto.strategy.prize;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;

public class SecondPrizeStrategy implements PrizeStrategy {
    private static final int PRIZE_AMOUNT = 30_000_000;

    @Override
    public boolean isWinning(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.getMatchCount(lotto);
        boolean isBonusNumberMatched = isBonusNumberMatched(lotto, winningNumbers);
        return matchCount == 5 && isBonusNumberMatched;
    }

    @Override
    public int getPrizeAmount() {
        return PRIZE_AMOUNT;
    }

    private boolean isBonusNumberMatched(Lotto lotto, WinningNumbers winningNumbers) {
        return winningNumbers.isBonusNumberMatched(lotto);
    }
}
