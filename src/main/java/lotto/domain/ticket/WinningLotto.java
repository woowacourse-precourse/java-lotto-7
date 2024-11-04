package lotto.domain.ticket;

import lotto.domain.number.BonusNumber;
import lotto.domain.number.LottoNumber;
import lotto.domain.result.LottoRank;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = BonusNumber.of(LottoNumber.of(bonusNumber), winningNumbers);
    }

    public LottoRank match(Lotto userLotto) {
        int matchCount = winningNumbers.countMatch(userLotto);
        boolean hasBonusNumber = userLotto.contains(bonusNumber.getNumber());
        return LottoRank.of(matchCount, hasBonusNumber);
    }
}