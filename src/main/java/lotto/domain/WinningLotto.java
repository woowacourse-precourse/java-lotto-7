package lotto.domain;

import lotto.wrapper.BonusNumber;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningNumbers, BonusNumber bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Rank determineRank(Lotto lotto) {
        int matchCount = lotto.matchCount(winningNumbers);
        boolean bonusMatch = lotto.matchesBonus(bonusNumber);

        return Rank.valueOf(matchCount, bonusMatch);
    }

}
