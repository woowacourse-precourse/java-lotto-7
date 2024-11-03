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

    public boolean isContains(final int userLottoNumber) {
        return lotto.isContains(userLottoNumber);
    }

    public Rank getRank(final Lotto lotto) {
        int matchCount = lotto.getMatchCount(this);
        boolean isContainsBonusNumber = lotto.isContains(bonusNumber);

        return Rank.getRank(matchCount, isContainsBonusNumber);
    }

    private BonusNumber validateDuplicate(final BonusNumber bonusNumber) {
        return ValidatorBuilder.from(bonusNumber)
                .validate(number -> lotto.isContains(bonusNumber), Exception.DUPLICATE_BONUS_NUMBER)
                .get();
    }
}
