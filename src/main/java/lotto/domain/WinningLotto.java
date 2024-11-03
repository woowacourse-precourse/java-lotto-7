package lotto.domain;

import lotto.exception.LottoApplicationException;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new LottoApplicationException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public MatchResult match(Lotto lotto) {
        int sameNumberCount = this.lotto.countSameNumbers(lotto);
        boolean bonusMatched = lotto.contains(bonusNumber);

        return new MatchResult(sameNumberCount, bonusMatched);
    }

}
