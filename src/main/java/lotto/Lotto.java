package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            }

            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            }
        }
    }


    public List<Integer> getLotto() {
        return numbers.stream()
                .sorted()
                .toList();
    }

}
