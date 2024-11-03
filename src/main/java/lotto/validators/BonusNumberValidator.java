package lotto.validators;

import lotto.models.constants.LottoValues;
import lotto.validators.constants.ErrorMessages;

import java.util.List;

public class BonusNumberValidator implements NumberInputValidator {
    private static final String LOTTO_SPLIT_DELIMITER = ",";

    public boolean isValid(String winningNumberInput, String bonusNumberInput) {
        checkInputType(bonusNumberInput);
        checkValueRange(bonusNumberInput);
        checkDuplicate(bonusNumberInput, winningNumberInput);
        return true;
    }

    public void checkValueRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < LottoValues.MIN_NUMBER.getValue() || bonusNumber > LottoValues.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_NOT_WITHIN_RANGE.getMessage());
        }
    }

    public void checkDuplicate(String input, String lottoNumbers) {
        List<String> numbers = List.of(lottoNumbers.split(LOTTO_SPLIT_DELIMITER));
        if (numbers.contains(input)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_IS_DUPLICATE.getMessage());
        }
    }
}
