package lotto;

import common.ErrorMessage;
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_WINNER_NUMBER_COUNT.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_LOTTO_NUMBER.getMessage());
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString(); // numbers 리스트를 문자열로 변환하여 반환
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
