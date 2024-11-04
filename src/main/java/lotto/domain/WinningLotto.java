package lotto.domain;

import lotto.common.ErrorMessage;

public class WinningLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(Lotto lotto, int bonusNumber) {
        if (!isLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.message());
        }
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_SHOULD_BE_UNIQUE.message());
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private boolean isLottoNumber(int number) {
        return (number >= MIN_NUMBER) && (number <= MAX_NUMBER);
    }

    public static WinningLotto of(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    @Override
    public String toString() {
        return "Number = " + lotto.toString() + ", Bonus = " + bonusNumber;
    }
}
