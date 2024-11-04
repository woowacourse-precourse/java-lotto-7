package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {
    private final Set<Integer> winningLottoNumbers;
    private final BonusNum bonusNum;

    public WinningLotto(final Lotto winningLotto, final BonusNum bonusNum) {
        this.winningLottoNumbers = new HashSet<>(winningLotto.getNumbers());
        this.bonusNum = bonusNum;
    }

    public int countMatches(final Lotto lotto) {
        return lotto.countMatchingNumbers(winningLottoNumbers);
    }

    public boolean containsBonusNum(final Lotto lotto) {
        return bonusNum.isContained(lotto);
    }

}
