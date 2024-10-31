package lotto.model.validator;

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
    }

    private void validateNumberRange() {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new InvalidLottoNumberException(OUT_OF_RANGE_BONUS_NUMBER);
        }
    }
}
