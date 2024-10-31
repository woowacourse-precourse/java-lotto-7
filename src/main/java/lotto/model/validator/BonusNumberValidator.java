package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.InvalidLottoNumberException.OUT_OF_RANGE_BONUS_NUMBER;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;
import lotto.util.LottoConstants;

public class BonusNumberValidator implements Validator{
    private final Integer bonusNumber;
    private final List<Integer> winNumbers;

    public BonusNumberValidator(Integer bonusNumber, List<Integer> winNumbers) {
        this.bonusNumber = bonusNumber;
        this.winNumbers = winNumbers;
    }

    @Override
    public void validate() {
        validateNumberRange();
        validateNotDuplicateWithWinningNumbers();
    }

    private void validateNumberRange() {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new InvalidLottoNumberException(OUT_OF_RANGE_BONUS_NUMBER);
        }
    }

    private void validateNotDuplicateWithWinningNumbers() {
        if (winNumbers.contains(bonusNumber)) {
            throw new InvalidLottoNumberException(DUPLICATE_BONUS_NUMBER);
        }
    }

}
