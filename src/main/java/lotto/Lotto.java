package lotto;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public String readNumberAscending(final String delimiter) {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(joining(delimiter));
    }
}
