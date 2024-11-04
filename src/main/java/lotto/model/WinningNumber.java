package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
    private static final String DELIMITER = ",";

    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumber(String numbers, int bonus) {
        this.numbers = createNumbers(numbers);
        this.bonus = bonus;
    }

    private List<Integer> createNumbers(String input) {
        List<Integer> numbers = Stream.of(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
