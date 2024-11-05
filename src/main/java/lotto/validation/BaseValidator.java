package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constatnt.ExceptionMessage;

public abstract class BaseValidator {

    protected void checkSize(List<Integer> numbers, int requiredCount) {
        if (numbers.size() != requiredCount) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_SIZE_INSUFFICIENT.getMessage());
        }
    }

    protected void checkDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATE_NUMBER.getMessage());
        }
    }
}
