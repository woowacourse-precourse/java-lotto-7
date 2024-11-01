package lotto.domain;

import java.util.List;

public class Winning {
    private final List<Integer> winningNumbers;

    private Winning(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }

    public static Winning create(List<Integer> numbers) {
        return new Winning(numbers);
    }
}
