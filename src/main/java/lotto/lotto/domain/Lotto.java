package lotto.lotto.domain;

import static lotto.common.exception.ExceptionName.LOTTO_LENGTH;
import static lotto.common.exception.ExceptionName.LOTTO_NUMBER_DOMAIN;
import static lotto.common.exception.ExceptionName.LOTTO_NUMBER_DUPLICATE;
import static lotto.common.rule.Rule.LOTTO_MAXIMUM_NUMBER;
import static lotto.common.rule.Rule.LOTTO_MINIMUM_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.rule.Rule;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != Rule.LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_LENGTH);
        }
    }

    private static void validateIndividualNumber(Integer number, Set<Integer> numberSet) {
        if (LOTTO_MINIMUM_NUMBER > number || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DOMAIN);
        }
        if (!numberSet.add(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            validateIndividualNumber(number, numberSet);
        }
    }
}
