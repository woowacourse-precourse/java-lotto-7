package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.error.Error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto newInstance() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45, 6);
        return new Lotto(randomNumbers);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateWithinRange(numbers);
        validateUnique(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateWithinRange(List<Integer> numbers) {
        for (int num: numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(Error.OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }
}
