package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoSettings;
import lotto.error.Error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_NUMBER = LottoSettings.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = LottoSettings.MAX_NUMBER.getValue();
    private static final int COUNT = LottoSettings.COUNT.getValue();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto newInstance() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER, COUNT);
        return new Lotto(randomNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateWithinRange(numbers);
        validateUnique(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(Error.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateWithinRange(List<Integer> numbers) {
        for (int num: numbers) {
            if (num < MIN_NUMBER || num > MAX_NUMBER) {
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
