package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class WinNumber {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinNumber(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinNumber of(Lotto lotto, BonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        return new WinNumber(lotto, bonusNumber);
    }

    private static void validate(Lotto lotto, BonusNumber bonusNumber) {
        validateNumberInWinningNumbers(lotto, bonusNumber);
    }

    private static void validateNumberInWinningNumbers(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getBonusNumber())) {
            throw InputException.from(ErrorMessage.BONUS_NUMBER_IS_IN_LOTTO_NUMBER);
        }
    }

    private int matchWithLotto(Lotto otherLotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(otherLotto.getNumbers()::contains)
                .count();
    }

    private boolean matchWithBonusNumber(Lotto otherLotto) {
        return otherLotto.contains(bonusNumber.getBonusNumber());
    }
}
