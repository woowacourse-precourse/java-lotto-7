package lotto.validators;

import java.util.List;

public class BonusNumberValidator implements NumberInputValidator {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    @Override
    public void validate(String input) {
        List<String> splitValues = List.of(input.split(":"));
        String bonusNumber = splitValues.get(0);
        String lottoNumbers = splitValues.get(1);

        checkInputType(bonusNumber);
        checkValueRange(bonusNumber);
        checkDuplicate(bonusNumber, lottoNumbers);
    }

    private void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < MIN_VALUE || amount > MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_NOT_WITHIN_RANGE.getMessage());
        }
    }

    private void checkDuplicate(String input, String lottoNumbers) {
        List<String> numbers = List.of(lottoNumbers.split(SPLIT_DELIMITER));
        if (numbers.contains(input)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_IS_DUPLICATE.getMessage());
        }
    }
}
