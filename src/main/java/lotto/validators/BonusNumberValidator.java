package lotto.validators;

import lotto.models.constants.LottoValues;
import lotto.validators.constants.ErrorMessages;

import java.util.List;

public class BonusNumberValidator implements NumberInputValidator {
    private static final String BONUS_SPLIT_DELIMITER = ":";
    private static final String LOTTO_SPLIT_DELIMITER = ",";

    @Override
    public boolean isValid(String input) {
        List<String> splitValues = List.of(input.split(BONUS_SPLIT_DELIMITER));
        String bonusNumber = splitValues.get(0);
        String lottoNumbers = splitValues.get(1);

        try {
            checkInputType(bonusNumber);
            checkValueRange(bonusNumber);
            checkDuplicate(bonusNumber, lottoNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < LottoValues.MIN_NUMBER.getValue() || amount > LottoValues.MAX_NUMBER.getValue()) {
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
