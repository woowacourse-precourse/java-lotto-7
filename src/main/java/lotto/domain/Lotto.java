package lotto.domain;

import lotto.util.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateIntList(numbers);

        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
