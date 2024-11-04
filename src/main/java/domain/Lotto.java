package domain;

import message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        Validate validate = new Validate();

        validate.validateIsCountSix(numbers);
        validate.validateIsInRange(numbers);
        validate.validateIsDuplicate(numbers);

        this.numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {

        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int getMatchCount(List<Integer> winning) {
        return (int) numbers.stream().filter(winning::contains).count();
    }

    // TODO: 추가 기능 구현
}
