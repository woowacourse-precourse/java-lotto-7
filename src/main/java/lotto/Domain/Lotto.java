package lotto.Domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Messages.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_SIZE.message);
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_RANGE.message);
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_DUPLICATE.message);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int matchNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}