package lotto.store.lotto.winner;

import lotto.store.lotto.Lotto;
import lotto.store.lotto.LottoNumber;
import lotto.store.lotto.winner.LottoRank;

import java.util.Objects;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final LottoNumber bonus;

    public WinningNumbers(Lotto winningLotto, LottoNumber bonus) {
        if(winningLotto.contains(bonus))
            throw new IllegalArgumentException("당첨 번호에 bonus 번호가 이미 존재합니다.");

        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }


    public LottoRank rank(Lotto lotto) {
        for (LottoRank value : LottoRank.values()) {
            if(value.matches(this, lotto))
                return value;
        }
        return LottoRank.FAIL;
    }

    protected int countMatch(Lotto lotto) {
        return winningLotto.countMatchingNumber(lotto);
    }

    protected boolean isBonusMatch(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
