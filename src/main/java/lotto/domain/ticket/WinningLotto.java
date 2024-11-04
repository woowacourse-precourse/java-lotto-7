package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.result.LottoRank;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public LottoRank match(Lotto userLotto) {
        int matchCount = winningNumbers.countMatch(userLotto);
        boolean hasBonusNumber = userLotto.contains(bonusNumber);
        return LottoRank.of(matchCount, hasBonusNumber);
    }
}