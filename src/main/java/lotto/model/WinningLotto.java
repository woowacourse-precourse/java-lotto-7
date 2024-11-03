package lotto.model;

import static lotto.common.AppConstant.LOTTO_END_RANGE;
import static lotto.common.AppConstant.LOTTO_START_RANGE;
import static lotto.common.AppErrorType.BONUS_NUMBER_DUPLICATE_ERROR;
import static lotto.common.AppErrorType.NUMBER_RANGE_ERROR;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;

        validateBonusNumberRange();
        validateDuplicatedBonusNumber();
    }

    private void validateBonusNumberRange() {
        if (LOTTO_START_RANGE > bonusNumber || bonusNumber > LOTTO_END_RANGE) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void validateDuplicatedBonusNumber() {
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    public List<Integer> getWinningNumberList() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
