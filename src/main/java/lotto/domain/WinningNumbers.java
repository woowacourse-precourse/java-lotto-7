package lotto.domain;

public class WinningNumbers {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    public WinningNumbers(Lotto winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public MatchResult match(Lotto lotto) {
        int matchCount = (int) lotto.countMatchNumbers(winningNumbers); // TODO long -> int
        boolean matchBonus = matchCount == 5 && lotto.containsNumber(bonusNumber);
        return new MatchResult(matchCount, matchBonus);
    }
}
