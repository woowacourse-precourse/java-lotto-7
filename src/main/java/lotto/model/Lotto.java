package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.constants.Error_Messages;

public class Lotto {
    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error_Messages.LOTTO_COUNT_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}