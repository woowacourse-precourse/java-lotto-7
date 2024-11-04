package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(Lotto purchaserLotto) {
        int matchCount = winningLotto.countMatchingNumbers(purchaserLotto.getNumbers());
        boolean hasBonus = purchaserLotto.hasBonusNumber(bonusNumber);
        return Rank.getRank(matchCount, hasBonus);
    }
}
