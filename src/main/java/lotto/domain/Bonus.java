package lotto.domain;

import static lotto.constant.LottoErrorConstant.ERROR_BONUS_NUMBER_NO_DUPLICATES;
import static lotto.constant.LottoErrorConstant.ERROR_BONUS_NUMBER_RANGE;

import java.util.List;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto lotto) {
        this.bonusNumber = bonusNumber;
        validate(lotto);
    }

    private void validate(Lotto lotto) {
        rangeValidate();
        hasDuplicated(lotto);
    }

    private void rangeValidate() {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
        }
    }

    private void hasDuplicated(Lotto lotto) {
        if (lotto.hasDuplicatedBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_NO_DUPLICATES);
        }
    }

    public boolean matching(List<Integer> userLotto) {
        if (userLotto.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

}
