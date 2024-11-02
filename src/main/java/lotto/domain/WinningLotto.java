package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Set<Integer> winningLottoNumbers;
    private final BonusNum bonusNum;

    public WinningLotto(final Lotto winningLotto, final BonusNum bonusNum) {
        this.winningLottoNumbers = new HashSet<>(winningLotto.getNumbers());
        this.bonusNum = bonusNum;
    }

    public boolean containsBonusNum(List<Integer> lottoNumbers) {
        return bonusNum.isContained(lottoNumbers);
    }

    public Set<Integer> getWinningLottoNumbers() {
        return Collections.unmodifiableSet(winningLottoNumbers);
    }
}
