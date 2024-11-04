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
        int matchCount = calculateMatchCount(lotto);
        boolean bonusMatch = bonusNumberMatch(lotto);

        return Rank.valueOf(matchCount, bonusMatch);
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean bonusNumberMatch(Lotto lotto) {
        return lotto.contains(bonusNumber.getNumber());
    }

}
