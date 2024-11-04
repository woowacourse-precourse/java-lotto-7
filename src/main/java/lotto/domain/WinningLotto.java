package lotto.domain;

import lotto.domain.vo.LottoNumber;
import lotto.exception.ErrorMessage;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private static void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        validateDuplicateWithBonusNumber(winningLotto, bonusNumber);
    }

    private static void validateDuplicateWithBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public Integer getCountMatchedNumber(Lotto lotto) {
        return lotto.countMatchingNumbers(winningLotto);
    }

    public Boolean checkBonusNumberMatched(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
