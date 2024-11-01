package lotto.validators;

import lotto.validators.constants.ErrorMessages;

import java.util.List;

public class BonusNumberValidator implements NumberInputValidator {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    @Override
    public boolean isValid(String input) {
        boolean isValid = false;
        List<String> splitValues = List.of(input.split(":"));
        String bonusNumber = splitValues.get(0);
        String lottoNumbers = splitValues.get(1);

        try {
            checkInputType(bonusNumber);
            checkValueRange(bonusNumber);
            checkDuplicate(bonusNumber, lottoNumbers);
            isValid = true;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessages.ERROR_HEADER.getMessage() + e.getMessage());
        }
        return isValid;
    }

    public void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < MIN_VALUE || amount > MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_NOT_WITHIN_RANGE.getMessage());
        }
    }

    public void checkDuplicate(String input, String lottoNumbers) {
        List<String> numbers = List.of(lottoNumbers.split(SPLIT_DELIMITER));
        if (numbers.contains(input)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_IS_DUPLICATE.getMessage());
        }
    }
}
