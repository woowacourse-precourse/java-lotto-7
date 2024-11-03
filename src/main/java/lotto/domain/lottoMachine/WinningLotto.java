package lotto.domain.lottoMachine;

import lotto.domain.lotto.Lotto;
import lotto.global.exception.Exception;
import lotto.global.exception.ValidatorBuilder;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.lotto = winningLotto;
        this.bonusNumber = validateDuplicate(bonusNumber);
    }

    public static WinningLotto of(final Lotto winningLotto, final BonusNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private BonusNumber validateDuplicate(BonusNumber bonusNumber) {
        return ValidatorBuilder.from(bonusNumber)
                .validate(number -> lotto.isContains(bonusNumber), Exception.DUPLICATE_BONUS_NUMBER)
                .get();
    }
}
