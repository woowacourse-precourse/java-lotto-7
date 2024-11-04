package lotto.domain.lotto;

import static lotto.domain.lotto.Constant.LOTTO_NUMBERS_LENGTH;
import static lotto.domain.lotto.Constant.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.lotto.Constant.MINIMUM_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String SHOULD_HAVE_SIX_NUMBER_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String NOT_DUPLICATE_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private static final String SHOULD_IN_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        copyNumbers.sort(Integer::compareTo);
        this.numbers = copyNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(SHOULD_HAVE_SIX_NUMBER_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) >= 2) {
                throw new IllegalArgumentException(NOT_DUPLICATE_MESSAGE);
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
                throw new IllegalArgumentException(SHOULD_IN_RANGE_MESSAGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
