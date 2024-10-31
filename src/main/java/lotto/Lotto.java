package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_NUMBER_ONLY_SIX));
        }
        if (!validateDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_DUPLICATE_NUMBER));
        }
        if (!checkLottoNumberRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_NUMBER_UNDER_ZERO_OVER_FORTY_FIVE));
        }
    }

    private static boolean validateDuplicateNumber(List<Integer> lotto) {
        Set<Integer> uniqueNumbers = new HashSet<>(lotto);
        return uniqueNumbers.size() == lotto.size();
    }

    private static boolean checkLottoNumberRange(List<Integer> lotto) {
        for (Integer number : lotto) {
            if (number < 1 ||number > 45) {
                return false;
            }
        }
        return true;
    }
}
