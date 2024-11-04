package lotto.domain;

import lotto.util.LottoNumberValidator;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) {
        LottoNumberValidator.validateNumberInRange(bonusNumber);
        LottoNumberValidator.validateBonusNumberDuplicates(lotto.getNumbers(), bonusNumber);
    }

    public int countMatchNumbers(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(number -> lotto.getNumbers().contains(number))
                .count();
    }

    public boolean matchBonusNumber(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }
}
