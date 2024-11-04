package lotto.domain;

import static lotto.common.exception.ExceptionMessages.WINNING_NUMBERS_CONTAIN_TOO_MANY_NUMBERS;

public class WinningNumbers {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    public WinningNumbers(Lotto winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public MatchResult match(Lotto lotto) {
        long matchCount = lotto.countMatchNumbers(winningNumbers);
        boolean matchBonus = matchCount == 5 && lotto.containsNumber(bonusNumber);
        if (matchCount > Integer.MAX_VALUE) {
            throw new IllegalStateException(WINNING_NUMBERS_CONTAIN_TOO_MANY_NUMBERS.getMessage());
        }
        return new MatchResult((int) matchCount, matchBonus);
    }
}
