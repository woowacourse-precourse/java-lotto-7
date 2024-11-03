package lotto.domain;

import lotto.Lotto;
import lotto.constant.ExceptionMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getValue())) {
            ExceptionMessage message = ExceptionMessage.DUPLICATE_BONUS;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    public boolean equalsWithBonus(int number) {
        return bonusNumber.isSame(number);
    }
}
