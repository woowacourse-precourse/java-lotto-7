package lotto.util;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleNumberRange(number);
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateSingleNumberRange(int number) {
        if (number < NUMBER_RANGE_MIN.getValue() || number > NUMBER_RANGE_MAX.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
