package lotto.model.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
