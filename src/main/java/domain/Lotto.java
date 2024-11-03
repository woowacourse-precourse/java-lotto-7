package domain;

import message.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUM_OF_NUMBERS.getErrorMessage());
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getErrorMessage());
        }
        if(numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {

        return numbers;
    }

    // TODO: 추가 기능 구현
}
