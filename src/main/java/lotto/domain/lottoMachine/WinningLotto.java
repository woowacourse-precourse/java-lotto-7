package lotto.domain.lottoMachine;

import lotto.domain.lotto.Lotto;
import lotto.global.exception.Exception;
import lotto.global.exception.ValidatorBuilder;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = validateDuplicate(bonusNumber);
    }

    public static WinningLotto of(final Lotto winningLotto, final BonusNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private BonusNumber validateDuplicate(BonusNumber bonusNumber) {
        return ValidatorBuilder.from(bonusNumber)
                .validate(number -> winningLotto.isContains(bonusNumber), Exception.DUPLICATE_BONUS_NUMBER)
                .get();
    }
}
