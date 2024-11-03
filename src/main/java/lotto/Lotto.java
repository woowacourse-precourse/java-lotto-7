package lotto;

import static lotto.AppConstants.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.AppConstants.INVALID_LOTTO_NUMBER_DUPLICATED;
import static lotto.AppConstants.LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT);
        }
        HashSet<Integer> singleNumbers = new HashSet<>(numbers);
        if (singleNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_DUPLICATED);
        }
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
