package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_LOTTO_LENGTH);
        }
        List<Integer> visitedNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number < LottoNumber.MIN_LOTTO_NUMBER || number > LottoNumber.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_OUT_OF_RANGE);
            }
            if (visitedNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_LOTTO_NUMBER);
            }
            visitedNumbers.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
