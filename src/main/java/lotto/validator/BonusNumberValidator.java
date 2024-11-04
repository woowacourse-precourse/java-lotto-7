package lotto.validator;

import lotto.Exception.BonusNumberException;

import static lotto.Exception.LottoExceptionType.*;
import static lotto.utils.LottoRules.LOTTO_MAX_NUMBER;
import static lotto.utils.LottoRules.LOTTO_MIN_NUMBER;
import static lotto.utils.TextUtils.*;

public class BonusNumberValidator implements Validator {

    @Override
    public void validate(String text) throws BonusNumberException {
        validateText(text);
        try {
            int bonusNumber = Integer.parseInt(text);
            validateNumber(bonusNumber);
        } catch (NumberFormatException e) {
            throw new BonusNumberException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }


    private void validateText(String text) throws BonusNumberException {
        if (isNullOrEmpty(text)) {
            throw new BonusNumberException(LOTTO_NUMBER_EMPTY_ERROR);
        }
        if (!isNumber(text)) {
            throw new BonusNumberException(LOTTO_NUMBER_NAN_ERROR);
        }
    }

    private void validateNumber(int bonusNumber) {
        if (!isValidRange(bonusNumber)) {
            throw new BonusNumberException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private boolean isValidRange(Integer number) {
        return number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER;
    }
}
