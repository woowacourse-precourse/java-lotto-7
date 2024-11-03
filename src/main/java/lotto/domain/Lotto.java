package lotto.domain;

import static lotto.constant.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConfig.DEFAULT_NUMBER_COUNT;

import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .map(Number::new)
            .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != DEFAULT_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        Set<Integer> filteredNumbers = Set.copyOf(numbers);
        if (filteredNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
            .map(Number::get)
            .toList();
    }

    public boolean contains(int number) {
        return numbers.contains(new Number(number));
    }
}
