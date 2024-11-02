package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

public class Lottery {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public Lottery(final Lotto lotto, final LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new InvalidLottoNumberException("보너스 번호가 로또에 포함되어서는 안됩니다");
        }
    }
}
