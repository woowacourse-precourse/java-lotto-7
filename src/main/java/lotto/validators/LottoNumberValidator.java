package lotto.validators;

import lotto.models.constants.LottoValues;
import lotto.validators.constants.ErrorMessages;

import java.util.List;
import java.util.Set;

public class LottoNumberValidator implements NumberInputValidator {
    private static final String SPLIT_DELIMITER = ",";

    @Override
    public boolean isValid(String input) {
        List<String> numbers = List.of(input.split(SPLIT_DELIMITER));

        try {
            checkArraySize(numbers);
            checkDuplicate(input);
            for (String number : numbers) {
                checkInputType(number);
                checkValueRange(number);
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void checkArraySize(List<String> numbers) {
        if (numbers.size() != LottoValues.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.INCORRECT_LOTTO_SIZE.getMessage());
        }
    }

    public void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < LottoValues.MIN_NUMBER.getValue() || amount > LottoValues.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_NOT_WITHIN_RANGE.getMessage());
        }
    }

    public void checkDuplicate(String input) {
        try {
            Set.of(input.split(SPLIT_DELIMITER));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_CONTAINS_DUPLICATE.getMessage());
        }
    }
}
