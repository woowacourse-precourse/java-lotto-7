package lotto.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.common.Constants.INVALID_LOTTO_SIZE;
import static lotto.common.Constants.LOTTO_SIZE;
import static lotto.view.OutputView.getErrorMessage;

public class ValidationUtils {

    public static void validateNumber (String rawInput, String errorMessage) {
        try {
            Long.parseLong(rawInput);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }

    public static void validateInRange (String rawNumber, Long minNumber, Long maxNumber, String errorMessage) {
        long number = Long.parseLong(rawNumber);

        if (number < minNumber || number > maxNumber) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }

    public static void validateAmountUnit (Integer number, Integer amountUnit, String errorMessage) {
        if (number % amountUnit != 0) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }

    public static void validateSize (List<Integer> numbers, Integer size, String errorMessage) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }

    public static void validateDuplicate (List<Integer> numbers, String errorMessage) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }

    public static void validateDuplicatedNumber (List<Integer> numbers, Integer newNumber, String errorMessage) {
        if (numbers.contains(newNumber)) {
            throw new IllegalArgumentException(getErrorMessage(errorMessage));
        }
    }
}
