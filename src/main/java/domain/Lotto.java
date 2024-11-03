package domain;

import message.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        Validate validate = new Validate();

        validate.validateIsCountSix(numbers);
        validate.validateIsInRange(numbers);
        validate.validateIsDuplicate(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {

        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
