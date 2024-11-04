package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constatnt.ExceptionMessage;

public class LottoNumberValidator {

    private static final int REQUIRED_NUMBER_COUNT = 6;

    public void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicates(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_SIZE_INSUFFICIENT.getMessage());
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATE_NUMBER.getMessage());
        }
    }
}
