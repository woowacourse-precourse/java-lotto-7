package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private final List<Integer> numbers;

    public Winning(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
