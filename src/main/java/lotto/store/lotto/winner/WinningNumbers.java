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
        Objects.requireNonNull(lotto);

        int matchingNumberCount = winningLotto.countMatchingNumber(lotto);
        if(matchingNumberCount == 6)
            return LottoRank.FIRST;
        if(matchingNumberCount == 5 && lotto.contains(bonus))
            return LottoRank.SECOND;
        if(matchingNumberCount == 5 && !lotto.contains(bonus))
            return LottoRank.THIRD;
        if(matchingNumberCount == 4)
            return LottoRank.FOURTH;
        if(matchingNumberCount == 3)
            return LottoRank.FIFTH;

        return LottoRank.FAIL;
    }
}
