package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Set<Integer> winningLottoNumbers;
    private final int bonusNum;

    public WinningLotto(final Lotto winningLotto, final int bonusNum) {
        this.winningLottoNumbers = new HashSet<>(winningLotto.getNumbers());
        this.bonusNum = bonusNum;
    }

    public boolean containsBonusNum(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNum);
    }

    public Set<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
