package lotto.domain;

public class WinningNumbers {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    public WinningNumbers(Lotto winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public MatchResult match(Lotto lotto) {
        long matchCount = lotto.countMatchNumbers(winningNumbers);
        boolean matchBonus = lotto.containsNumber(bonusNumber);
        return new MatchResult(matchCount, matchBonus);
    }
}
