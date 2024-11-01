package lotto.model.validator.lotto;

import static lotto.exception.InvalidLottoNumberException.DUPLICATE_BONUS_NUMBER;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;

public class BonusNumberValidator extends NumberValidator {
    private final Integer bonusNumber;

    public BonusNumberValidator(Integer bonusNumber, List<Integer> winNumbers) {
        super(winNumbers);
        this.bonusNumber = bonusNumber;
    }

    @Override
    protected void validateWithHook() {
        validateNumberDuplicates();
    }

    private void validateNumberDuplicates() {
        if (winNumbers.contains(bonusNumber)) {
            throw new InvalidLottoNumberException(DUPLICATE_BONUS_NUMBER);
        }
    }
}
