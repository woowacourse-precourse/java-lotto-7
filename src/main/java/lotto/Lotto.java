package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
        numbers.stream()
                .forEach(this::validateNumber);
    }

    private void validateNumber(int number) {
        if (number < 0 || number > 46) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return "[" + String.join(", ",
                numbers.stream()
                        .map(String::valueOf)
                        .toList()
        ) + "]";
    }
}
