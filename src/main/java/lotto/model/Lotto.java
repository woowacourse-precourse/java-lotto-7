package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        return numbers.toString();
    }
}
