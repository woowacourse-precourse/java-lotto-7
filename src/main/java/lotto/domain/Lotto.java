package lotto.domain;

import java.util.Comparator;
import java.util.List;
import lotto.util.ExceptionMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_SIX_LOTTO_NUMBER.getMessage());
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATED_NUMBERS.getMessage());
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
