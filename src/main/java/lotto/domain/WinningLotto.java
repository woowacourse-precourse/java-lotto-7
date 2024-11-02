package lotto.domain;

import lotto.validator.WinningLottoValidator;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, int bonusNumber){
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
