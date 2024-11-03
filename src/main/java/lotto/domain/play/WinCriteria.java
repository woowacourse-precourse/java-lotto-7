package lotto.domain.play;

import lotto.domain.rule.PrizeRank;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoNumber;

public class WinCriteria {
    private final Lotto winLotto;
    private final LottoNumber bonusNumber;

    public WinCriteria(Lotto winLotto, LottoNumber bonusNumber) {
        validateNoDuplicateBetween(winLotto, bonusNumber);
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateNoDuplicateBetween(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.has(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복이 없어야 합니다.");
        }
    }

    public PrizeRank findPrize(Lotto another) {
        boolean hasBonusNumber = another.has(bonusNumber);
        int matchCount = winLotto.countMatch(another);
        return PrizeRank.find(matchCount, hasBonusNumber);
    }
}
