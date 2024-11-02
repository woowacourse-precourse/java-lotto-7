package lotto.model.domain;

import static lotto.model.domain.LottoConstant.MAX_NUM;
import static lotto.model.domain.LottoConstant.MIN_NUM;
import static lotto.model.domain.LottoError.DUPLICATE_BONUS_NUMBER_ERR;
import static lotto.model.domain.LottoError.LOTTO_NUM_OUT_OF_RANGE_ERR;

import java.util.List;

public class LottoWinningNumbers extends Lotto {
    private final Integer bonusNumber;

    public LottoWinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        boolean isInRange = bonusNumber >= MIN_NUM && bonusNumber <= MAX_NUM;

        if (!isInRange) {
            throw new IllegalArgumentException(LOTTO_NUM_OUT_OF_RANGE_ERR);
        }
    }

    private void validateDuplicateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERR);
        }
    }
}
