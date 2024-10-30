package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int getMatchingCount(Lotto winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers.getNumbers()::contains).count();
    }
}
