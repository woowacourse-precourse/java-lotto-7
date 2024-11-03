package model.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public boolean isDuplicateBonus(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
