package lotto.model;

import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;
import static lotto.provider.NumberProvider.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT);
        }
        for(Integer number: numbers){
            if (number < MIN_NUMBER || number > MAX_NUMBER)
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    private static boolean isDuplicateNumber(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != numbers.size();
    }

}
