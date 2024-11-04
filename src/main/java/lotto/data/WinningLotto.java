package lotto.data;

import static lotto.config.constant.ExceptionMessageConstant.DUPLICATED_LOTTO_NUMBER;
import static lotto.config.constant.ExceptionMessageConstant.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.config.constant.LottoNumberConstant.MAX_NUMBER;
import static lotto.config.constant.LottoNumberConstant.MIN_NUMBER;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
        if (isDuplicated(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
        }
    }

    private boolean isOutOfRange(int bonusNumber) {
        return !(MIN_NUMBER <= bonusNumber && bonusNumber <= MAX_NUMBER);
    }

    private boolean isDuplicated(int bonusNumber) {
        for (int number : getNumbers()) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
