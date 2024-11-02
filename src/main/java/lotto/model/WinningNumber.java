package lotto.model;

import java.util.Set;
import java.util.TreeSet;

public class WinningNumber {
    private final Set<Integer> numbers;

    public WinningNumber(Set<Integer> numbers) {
        this.numbers = new TreeSet<>(numbers);
    }

    public Set<Integer> getNumbers() {
        return new TreeSet<>(numbers);
    }
}
