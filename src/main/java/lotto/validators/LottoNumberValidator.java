package lotto.validators;

import java.util.List;
import java.util.Set;

public class LottoNumberValidator implements NumberInputValidator {
    private static final String SPLIT_DELIMITER = ",";
    private static final int ARRAY_SIZE = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    @Override
    public void validate(String input) {
        List<String> numbers = List.of(input.split(SPLIT_DELIMITER));

        if (numbers.size() != ARRAY_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INCORRECT_NUMBER_COUNT.getMessage());
        }
        checkDuplicate(input);

        for (String number : numbers) {
            checkInputType(number);
            checkValueRange(number);
        }
    }

    private void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < MIN_VALUE || amount > MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_NOT_WITHIN_RANGE.getMessage());
        }
    }

    private void checkDuplicate(String input) {
        try {
            Set.of(input.split(SPLIT_DELIMITER));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_CONTAINS_DUPLICATE.getMessage());
        }
    }
}
