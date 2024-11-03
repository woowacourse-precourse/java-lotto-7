package lotto;

import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.LottoMachine.MAX_LOTTO_NUMBER_RANGE;
import static lotto.LottoMachine.MIN_LOTTO_NUMBER_RANGE;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(final int number) {
        this.bonusNumber = number;
    }

    public static BonusNumber of(final int bonusNumber) {
        validateLottoNumberRange(bonusNumber);
        return new BonusNumber(bonusNumber);
    }

    public int get() {
        return bonusNumber;
    }

    private static void validateLottoNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER_RANGE || number > MAX_LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
