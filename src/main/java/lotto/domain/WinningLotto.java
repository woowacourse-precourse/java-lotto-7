package lotto.domain;

import lotto.validator.WinningLottoValidator;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(final Lotto lotto, final LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final Lotto lotto, final int bonusNumber) {
        WinningLottoValidator.validateWinningLotto(lotto.getNumberValues(), bonusNumber);
        return new WinningLotto(lotto, LottoNumber.valueOf(bonusNumber));
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
