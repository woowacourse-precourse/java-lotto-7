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

    public static WinningLotto of(List<Integer> numbers, int bonusNumber){
        WinningLottoValidator.validateWinningLotto(numbers, bonusNumber);
        return new WinningLotto(Lotto.from(numbers), LottoNumber.from(bonusNumber));
    }
}
