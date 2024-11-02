package lotto.domain;

import java.util.List;

public class Lotto {

    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = Numbers.from(numbers);
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
