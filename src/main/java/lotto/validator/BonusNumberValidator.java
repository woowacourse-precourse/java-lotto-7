package lotto.validator;

import lotto.Exception.BonusNumberException;
import lotto.Exception.WinningNumberException;

import static lotto.Exception.LottoExceptionType.*;
import static lotto.utils.LottoRules.LOTTO_MAX_NUMBER;
import static lotto.utils.LottoRules.LOTTO_MIN_NUMBER;

public class BonusNumberValidator implements Validator {
    private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";

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

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isNumber(String text) {
        return text.matches(NUMBER_PATTERN);
    }

    private boolean isValidRange(Integer number) {
        return number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER;
    }
}
